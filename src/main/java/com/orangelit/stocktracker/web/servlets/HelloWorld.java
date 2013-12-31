package com.orangelit.stocktracker.web.servlets;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.google.sitebricks.At;

@At("/helloworld")
public class HelloWorld {

	@Inject
	@Named("message")
	String messageString;

    public String getMessage() {
    	return this.messageString;
	}
}
