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
import com.orangelit.stocktracker.web.views.DashboardView;
import com.orangelit.stocktracker.web.views.HomeView;
import com.orangelit.stocktracker.web.views.LoginView;
import com.orangelit.stocktracker.web.views.RegisterView;

public class GuiceCreator extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {

		Injector injector = Guice.createInjector(
            new SitebricksModule() {
                protected void configureSitebricks() {

                    scan(HomeView.class.getPackage());
                    scan(LoginView.class.getPackage());
                    scan(RegisterView.class.getPackage());
                    scan(DashboardView.class.getPackage());

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
