package com.orangelit.stocktracker.authentication.managers;

import com.orangelit.stocktracker.authentication.exceptions.DuplicateUserException;
import com.orangelit.stocktracker.authentication.exceptions.UnauthorizedException;
import com.orangelit.stocktracker.authentication.models.User;
import com.orangelit.stocktracker.common.exceptions.InvalidInputException;

public interface AuthenticationManager {

    public User register(String firstName,
                         String lastName,
                         String username,
                         String password,
                         String passwordConfirm)
        throws InvalidInputException, DuplicateUserException;

    public String getToken(String username, String password, String hostname) throws UnauthorizedException;

    public Boolean isValidToken(String token);

    public void expireToken(String token);

}
