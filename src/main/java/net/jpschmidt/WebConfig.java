package net.jpschmidt;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;


@Configuration

public class WebConfig {


    public void addResourceHandlers (ResourceHandlerRegistry registry) {
        registry.addResourceHandler (
                "/images/**",
                "/css/**",
                "/js/**",
                "/activity/js/**",
                "/activity/edit/js/**",
                "/rental/js/**",
                "/rental/edit/js/**",
                "/restaurant/js/**",
                "/restaurant/edit/js/**",
                "/rates/edit/js/**",
                "/rates/js/**")
                .addResourceLocations (
                        "classpath:/static/images/",
                        "classpath:/static/css/",
                        "classpath:/static/js/",
                        "classpath:/static/js/",
                        "classpath:/static/js/");
    }

}