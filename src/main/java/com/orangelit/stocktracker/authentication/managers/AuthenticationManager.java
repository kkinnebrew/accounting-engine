package com.orangelit.stocktracker.authentication.managers;

import com.orangelit.stocktracker.authentication.exceptions.UnauthorizedException;
import com.orangelit.stocktracker.common.exceptions.InvalidInputException;

public interface AuthenticationManager {

    public void register(String firstName, String lastName, String username, String password, String passwordConfirm) throws InvalidInputException;
    public String getToken(String username, String password) throws UnauthorizedException;
    public Boolean isValidToken(String token);
    public void expireToken(String token);

}
