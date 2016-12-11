package steyn.gareth.lekkersakos;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Application entry point and configuration for Spring Boot.
 * @author Gareth
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	static final Logger logger = LogManager.getLogger(Application.class.getName());
 
	static String IMAGE_DIR;
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
 
    public static void main(String[] args) throws IOException {
    	logger.info("Starting application...");
    	
    	IMAGE_DIR = new File(".").getCanonicalPath() + File.separator + "img" + File.separator;
    	logger.debug(String.format("IMAGE_DIR > %s", IMAGE_DIR));
    	
        SpringApplication.run(Application.class, args);
    }
}
