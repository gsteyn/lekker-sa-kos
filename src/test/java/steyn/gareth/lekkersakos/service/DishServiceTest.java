package steyn.gareth.lekkersakos.service;

import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.Assert;
import steyn.gareth.lekkersakos.AbstractTest;
import steyn.gareth.lekkersakos.model.Dish;

/**
 * Unit tests for the DishService and DishServiceBean.
 * 
 * @author Gareth
 */
public class DishServiceTest extends AbstractTest {

	@Autowired
	private DishService fixture;
	
	@Test
	public void testFindAll() {
		Collection<Dish> dishes = fixture.findAll();
		
		Assert.assertNotNull("failure -> expected not null", dishes);
	}
	
}
