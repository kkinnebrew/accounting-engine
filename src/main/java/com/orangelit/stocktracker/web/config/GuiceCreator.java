package com.orangelit.stocktracker.web.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.sitebricks.SitebricksModule;
import com.orangelit.stocktracker.web.modules.PersistenceModule;
import com.orangelit.stocktracker.web.servlets.authentication.AuthenticateService;
import com.orangelit.stocktracker.web.servlets.authentication.LoginService;
import com.orangelit.stocktracker.web.servlets.authentication.LogoutService;
import com.orangelit.stocktracker.web.servlets.authentication.RegisterService;
import com.orangelit.stocktracker.web.servlets.stocktracker.GetPortfoliosService;

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

                    at("/portfolios").serve(GetPortfoliosService.class);

                }
            },
            new PersistenceModule()
		);

		return injector;

	}

}
