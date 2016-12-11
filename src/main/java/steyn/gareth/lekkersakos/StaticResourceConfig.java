package steyn.gareth.lekkersakos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class StaticResourceConfig extends WebMvcConfigurerAdapter {
	
	static final Logger logger = LogManager.getLogger(StaticResourceConfig.class.getName());
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		logger.info("> addResourceHandlers");
		
		registry.addResourceHandler("/img/**").addResourceLocations("file:" + Application.IMAGE_DIR);
		super.addResourceHandlers(registry);
	}
	
}
