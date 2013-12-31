package com.orangelit.stocktracker.web.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.sitebricks.SitebricksModule;
import com.orangelit.stocktracker.web.servlets.*;

public class GuiceCreator extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {

		Injector injector = Guice.createInjector(
            new SitebricksModule() {
                protected void configureSitebricks() {

                    at("/login").serve(LoginService.class);
                    at("/authenticate").serve(AuthenticateService.class);
                    at("/logout").serve(LogoutService.class);

                    //Injection value of message
                    bindConstant().annotatedWith(Names.named("message")).to("HelloWorld!!");
                }
            }
		);

		return injector;

	}

}
