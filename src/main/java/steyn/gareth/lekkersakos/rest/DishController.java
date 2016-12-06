package steyn.gareth.lekkersakos.rest;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(value = "/dishes", produces = MediaType.APPLICATION_JSON_VALUE)
public class DishController {
	
	static final Logger logger = LogManager.getLogger(DishController.class.getName());
	
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
	
}
