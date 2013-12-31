package com.orangelit.stocktracker.web.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.sitebricks.SitebricksModule;
import com.orangelit.stocktracker.web.modules.PersistenceModule;
import com.orangelit.stocktracker.web.servlets.*;
import sun.jvm.hotspot.asm.Register;

public class GuiceCreator extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {

		Injector injector = Guice.createInjector(
            new SitebricksModule() {
                protected void configureSitebricks() {

                    at("/register").serve(RegisterService.class);
                    at("/login").serve(LoginService.class);
                    at("/authenticate").serve(AuthenticateService.class);
                    at("/logout").serve(LogoutService.class);

                    //Injection value of message
                    bindConstant().annotatedWith(Names.named("message")).to("HelloWorld!!");
                }
            },
            new PersistenceModule()
		);

		return injector;

	}

}
