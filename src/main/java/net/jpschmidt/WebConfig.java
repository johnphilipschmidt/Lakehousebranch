package net.jpschmidt;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;


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
    private ISpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.addDialect(new Java8TimeDialect());
        engine.setTemplateResolver(templateResolver);
        return engine;
    }
}