package com.orangelit.stocktracker.web.modules;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.googlecode.htmleasy.HtmleasyProviders;
import com.orangelit.stocktracker.web.resources.About;
import com.orangelit.stocktracker.web.resources.AuthenticationResource;
import com.orangelit.stocktracker.web.resources.HelloResource;

public class HelloModule implements Module
{
    public void configure(final Binder binder)
    {
        // Ensure Htmleasy Provider classes are found
        for (Class<?> c : HtmleasyProviders.getClasses()) {
            binder.bind(c);
        }

        binder.bind(HelloResource.class);
        binder.bind(AuthenticationResource.class);
        binder.bind(About.class);
    }
}