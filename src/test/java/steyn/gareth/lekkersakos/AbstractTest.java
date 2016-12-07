package steyn.gareth.lekkersakos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Abstract parent test class for all JUnit test classes. This class configures the 
 * test ApplicationContext and test runner environment.
 * 
 * @author Gareth
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public abstract class AbstractTest {
	protected Logger logger = LogManager.getLogger(AbstractTest.class.getName());
}
