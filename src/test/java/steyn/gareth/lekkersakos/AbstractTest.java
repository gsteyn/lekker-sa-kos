package steyn.gareth.lekkersakos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Abstract parent test class for all JUnit test classes. This class configures the 
 * test ApplicationContext and test runner environment.
 * 
 * @author Gareth
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public abstract class AbstractTest {
	protected Logger logger = LogManager.getLogger(AbstractTest.class.getName());
}
