package net.jpschmidt;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import nz.net.ultraq.thymeleaf.decorators.strategies.GroupingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

@SpringBootApplication
public class AppMain {
	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}
	public static void main(String[] args) {
        SpringTemplateEngine engine = new SpringTemplateEngine ();

        engine.addDialect (new LayoutDialect (new GroupingStrategy ()));
		SpringApplication.run(AppMain.class, args);
	}
	private ISpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.addDialect(new Java8TimeDialect());
		engine.setTemplateResolver(templateResolver);
		return engine;
	}


}
