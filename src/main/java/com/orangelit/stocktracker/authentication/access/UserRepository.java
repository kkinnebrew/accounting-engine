package com.orangelit.stocktracker.authentication.access;

import com.google.inject.persist.Transactional;
import com.orangelit.stocktracker.authentication.exceptions.DuplicateUserException;
import com.orangelit.stocktracker.authentication.models.User;
import com.orangelit.stocktracker.common.access.AbstractRepository;

import javax.persistence.Query;
import java.util.UUID;

public class UserRepository extends AbstractRepository {

    @Transactional
    public User registerUser(String firstName,
                             String lastName,
                             String email,
                             String password) throws DuplicateUserException {

        if (userExists(email)) {
            throw new DuplicateUserException("Email: " + email + " already exists.");
        }

        UserEntity userEntity = new UserEntity();

        userEntity.userId = UUID.randomUUID().toString();
        userEntity.firstName = firstName;
        userEntity.lastName = lastName;
        userEntity.email = email;
        userEntity.password = password;
        userEntity.isActive = true;

        getEntityManager().persist(userEntity);

        return mapUser(userEntity);

    }

    private Boolean userExists(String username) {
        Query query = getEntityManager().createNativeQuery("select * from Users WHERE email = ?", UserEntity.class);
        query.setParameter(1, username);
        return query.getResultList().size() > 0;
    }

    public User getUser(String userId) {
        UserEntity userEntity =  getEntityManager().find(UserEntity.class, userId);
        return mapUser(userEntity);
    }

    public User getUserByCredentials(String email, String password) {

        Query query = getEntityManager().createNativeQuery("select * from Users WHERE email = ? AND password = ?", UserEntity.class);
        query.setParameter(1, email);
        query.setParameter(2, password);

        UserEntity userEntity = (UserEntity)query.getSingleResult();
        return mapUser(userEntity);

    }

    private User mapUser(UserEntity userEntity) {

        User user = new User();

        user.userId = userEntity.userId;
        user.firstName = userEntity.firstName;
        user.lastName = userEntity.lastName;
        user.email = userEntity.email;
        user.isActive = userEntity.isActive;

        return user;

    }

}
