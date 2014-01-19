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

        userEntity.setUserId(UUID.randomUUID().toString());
        userEntity.setFirstName(firstName);
        userEntity.setLastName(lastName);
        userEntity.setEmail(email);
        userEntity.setPassword(password);
        userEntity.setIsActive(true);

        getEntityManager().persist(userEntity);

        return mapUser(userEntity);

    }

    private Boolean userExists(String username) {
        Query query = getEntityManager().createNativeQuery("select * from Users WHERE email = ?", UserEntity.class);
        query.setParameter(1, username);
        return query.getResultList().size() > 0;
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

        user.setUserId(userEntity.getUserId());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setEmail(userEntity.getEmail());
        user.setIsActive(userEntity.getIsActive());

        return user;

    }

}
