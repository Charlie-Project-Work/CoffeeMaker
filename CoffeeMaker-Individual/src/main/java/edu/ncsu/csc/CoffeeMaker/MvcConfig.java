package edu.ncsu.csc.CoffeeMaker;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Spring Security configuration class for MVC webpages.
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * Add view controllers for login management.
     */
    @Override
    public void addViewControllers ( final ViewControllerRegistry registry ) {
        registry.addViewController( "/addrecipe" ).setViewName( "addrecipe" );
        registry.addViewController( "/" ).setViewName( "index" );
        registry.addViewController( "/deleterecipe" ).setViewName( "deleterecipe" );
        registry.addViewController( "/editrecipe" ).setViewName( "editrecipe" );
        registry.addViewController( "/editrecipe2" ).setViewName( "editrecipe2" );
        registry.addViewController( "/inventory" ).setViewName( "inventory" );
        registry.addViewController( "/inventory2" ).setViewName( "inventory2" );
        registry.addViewController( "/makecoffee" ).setViewName( "makecoffee" );
        registry.addViewController( "/updateInventory" ).setViewName( "updateInventory" );
        registry.addViewController( "/login" ).setViewName( "userLogin" );
        registry.addViewController( "/fulfillorders" ).setViewName( "fulfillorders" );
    }

}
