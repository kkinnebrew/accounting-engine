package com.orangelit.stocktracker.authentication.access;

import com.google.inject.persist.Transactional;
import com.orangelit.stocktracker.authentication.exceptions.DuplicateUserException;
import com.orangelit.stocktracker.authentication.models.User;
import com.orangelit.stocktracker.common.access.BaseRepository;

import javax.persistence.Query;

public class UserRepository extends BaseRepository {

    @Transactional
    public User registerUser(String firstName,
                             String lastName,
                             String email,
                             String password) throws DuplicateUserException {

        if (userExists(email)) {
            throw new DuplicateUserException("Email: " + email + " already exists.");
        }

        User user = new User(firstName, lastName, email, password);
        getEntityManager().persist(user);
        return user;

    }

    private Boolean userExists(String username) {
        Query query = getEntityManager().createNativeQuery("select * from Users WHERE email = ?", User.class);
        query.setParameter(1, username);
        return query.getResultList().size() > 0;
    }

    public User getUser(String userId) {
        return getEntityManager().find(User.class, userId);
    }

    public User getUserByCredentials(String email, String password) {

        Query query = getEntityManager().createNativeQuery("select * from Users WHERE email = ? AND password = ?", User.class);
        query.setParameter(1, email);
        query.setParameter(2, password);

        return (User)query.getSingleResult();

    }

}
