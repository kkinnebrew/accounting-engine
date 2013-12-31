package com.orangelit.stocktracker.web.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.sitebricks.SitebricksModule;
import com.orangelit.stocktracker.web.servlets.HelloWorld;
import com.orangelit.stocktracker.web.servlets.MyEndpoint;

public class GuiceCreator extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {

		Injector injector = Guice.createInjector (
            new SitebricksModule() {
                 protected void configureSitebricks() {
                    // scan class Example's package and all descendants
                    scan(HelloWorld.class.getPackage());
//                    scan(MyEndpoint.class.getPackage());
                     at("/testioc").serve(MyEndpoint.class);
                    //Injection value of message
                    bindConstant().annotatedWith(Names.named("message")).to("HelloWorld!!");
                }
            }
		);

		return injector;

	}

}
