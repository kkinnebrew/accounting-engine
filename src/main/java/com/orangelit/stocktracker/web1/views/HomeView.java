package com.orangelit.stocktracker.web1.views;

import com.google.sitebricks.At;
import com.google.sitebricks.Show;
import com.google.sitebricks.http.Get;

@At("/") @Show("Home.html")
public class HomeView {

    @Get
    public void view() {}

}
