package steyn.gareth.lekkersakos.service;

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
		
}
