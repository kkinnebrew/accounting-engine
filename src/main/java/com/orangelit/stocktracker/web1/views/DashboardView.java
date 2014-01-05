package com.orangelit.stocktracker.web1.views;

import com.google.sitebricks.At;
import com.google.sitebricks.Show;
import com.google.sitebricks.http.Get;

@At("/dashboard") @Show("Dashboard.html")
public class DashboardView {

    @Get
    public void view() {}

}
