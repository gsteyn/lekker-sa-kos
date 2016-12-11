package steyn.gareth.lekkersakos.service;

import java.io.IOException;
import java.util.Collection;

import steyn.gareth.lekkersakos.model.Dish;

/**
 * An interface to define all the public business behaviours or operations 
 * for the {@link Dish} entity.  
 * 
 * @author Gareth
 */
public interface DishService {

	/**
	 * Final all Dish entities.
	 * @return a collection of Dish objects.
	 */
	Collection<Dish> findAll();

	/**
	 * Generates the image of the given dish and returns the URL to the resource.
	 * @param dishId the dish whose image needs to be generated.
	 * @return the URL to the image resource.
	 * @throws IOException 
	 */
	String getImageLocation(String dishId) throws IOException;
	
}
