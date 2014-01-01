package com.orangelit.stocktracker.web.views;

import com.google.sitebricks.At;
import com.google.sitebricks.Show;
import com.google.sitebricks.http.Get;

@At("/login") @Show("Login.html")
public class LoginView {

    @Get
    public void view() {}

}
