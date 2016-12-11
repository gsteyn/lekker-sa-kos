package steyn.gareth.lekkersakos.rest;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import steyn.gareth.lekkersakos.model.Dish;
import steyn.gareth.lekkersakos.service.DishService;

/**
 * REST controller that handles operations for Dishes.
 * Currently only returns all the dishes. More operations to follow. 
 *  
 * @author Gareth
 */
@RestController
@RequestMapping(
		value = "/api/dishes",
		produces = MediaType.APPLICATION_JSON_VALUE)
public class DishController extends BaseController {
	
	static final Logger logger = LogManager.getLogger(DishController.class.getName());
	
	@Value("${app.server.url}")
    private String serverUrl;
	
	@Autowired
	private DishService dishService;
	
	/**
	 * Web service endpoint to retrieve all Dish entities. 
	 * The service returns the collection of Dishes as JSON.
	 * @return a ResponseEntity containing a Collection of Dish objects.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Dish>> findAll() {
		logger.debug("> findAll");
		return new ResponseEntity<Collection<Dish>> (dishService.findAll(), HttpStatus.OK);
	}

	/**
	 * Returns a location of the given dish's image which can then be retrieved via the browser, etc.
	 * @param dishId the dish whose image needs to be generated and returned.
	 * @return a URL pointing to the image resource on the server.
	 */
	@RequestMapping(
			value = "/image/{dishId}",
			method = RequestMethod.GET)
	public ResponseEntity<Map<String, String>> getImageLocation(@PathVariable String dishId) throws IOException {
		logger.debug("> getImageLocation");
		
		String imageLocation = dishService.getImageLocation(dishId);
		imageLocation = serverUrl + imageLocation;
		logger.debug(String.format("imageLocation > %s", imageLocation));
		
		logger.debug("< getImageLocation");
		
		Map<String, String> response = Collections.singletonMap("imageLocation", imageLocation);
		
		return new ResponseEntity<Map<String, String>> (response, HttpStatus.OK);
	}
	
}
