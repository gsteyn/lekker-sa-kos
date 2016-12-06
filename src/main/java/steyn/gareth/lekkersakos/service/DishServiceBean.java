package steyn.gareth.lekkersakos.service;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import steyn.gareth.lekkersakos.model.Dish;
import steyn.gareth.lekkersakos.repository.DishRepository;

/**
 * Encapsulates all business behaviour and operations for the 
 * Dish entity.
 * 
 * @author Gareth
 */
@Service
@Transactional
public class DishServiceBean implements DishService {
	static final Logger logger = LogManager.getLogger(DishServiceBean.class.getName());
	
	@Autowired
	private DishRepository dishRepo;
	
	@Override
	public Collection<Dish> findAll() {
		logger.debug("> findAll");
		
		Collection<Dish> dishes = (Collection<Dish>) dishRepo.findAll();
		
		logger.debug("< findAll");
		return dishes;
	}

}