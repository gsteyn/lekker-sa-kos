package steyn.gareth.lekkersakos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Application entry point and configuration for Spring Boot.
 * @author Gareth
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	static final Logger logger = LogManager.getLogger(Application.class.getName());
 
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
 
    public static void main(String[] args) {
    	logger.info("Starting application...");
        SpringApplication.run(Application.class, args);
    }
}
