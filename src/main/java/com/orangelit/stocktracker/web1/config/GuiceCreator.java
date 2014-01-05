package com.orangelit.stocktracker.web1.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.sitebricks.SitebricksModule;
import com.orangelit.stocktracker.web1.modules.PersistenceModule;
import com.orangelit.stocktracker.web1.servlets.authentication.AuthenticateService;
import com.orangelit.stocktracker.web1.servlets.authentication.LoginService;
import com.orangelit.stocktracker.web1.servlets.authentication.LogoutService;
import com.orangelit.stocktracker.web1.servlets.authentication.RegisterService;
import com.orangelit.stocktracker.web1.servlets.stocktracker.GetPortfoliosService;
import com.orangelit.stocktracker.web1.views.DashboardView;
import com.orangelit.stocktracker.web1.views.HomeView;
import com.orangelit.stocktracker.web1.views.LoginView;
import com.orangelit.stocktracker.web1.views.RegisterView;

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

                    at("/api/register").serve(RegisterService.class);
                    at("/api/login").serve(LoginService.class);
                    at("/api/authenticate").serve(AuthenticateService.class);
                    at("/api/logout").serve(LogoutService.class);

                    at("/api/portfolios").serve(GetPortfoliosService.class);

                }
            },
            new PersistenceModule()
		);

		return injector;

	}

}
