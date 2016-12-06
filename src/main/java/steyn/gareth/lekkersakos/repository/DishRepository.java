package steyn.gareth.lekkersakos.repository;

import org.springframework.data.repository.CrudRepository;

import steyn.gareth.lekkersakos.model.Dish;

/**
 * Extending {@link CrudRepository} gives this interface all the traditional CRUD operations 
 * by default. When injecting this interface via Spring, the resulting polymorphic class 
 * that implements this interface will be able to create, read, update and delete 
 * {@link Dish} entities.
 * @author Gareth
 */
public interface DishRepository extends CrudRepository<Dish, Long> {

}
