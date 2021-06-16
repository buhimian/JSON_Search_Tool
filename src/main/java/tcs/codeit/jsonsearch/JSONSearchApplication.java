package tcs.codeit.jsonsearch;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JSONSearchApplication {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(JSONSearchApplication.class).run(args);
	}

}
