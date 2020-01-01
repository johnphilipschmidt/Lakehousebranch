package net.jpschmidt;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import nz.net.ultraq.thymeleaf.decorators.strategies.GroupingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.thymeleaf.spring5.SpringTemplateEngine;

@SpringBootApplication
public class AppMain {
	public static void main(String[] args) {
        SpringTemplateEngine engine = new SpringTemplateEngine ();

        engine.addDialect (new LayoutDialect (new GroupingStrategy ()));
		SpringApplication.run(AppMain.class, args);
	}
}
