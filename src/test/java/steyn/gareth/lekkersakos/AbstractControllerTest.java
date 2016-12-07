package steyn.gareth.lekkersakos;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import steyn.gareth.lekkersakos.rest.BaseController;

/**
 * Extends functionality from {@link AbstractTest}.
 * This abstract class is the parent of all web controller JUnit test 
 * classes. The class class prepares a {@link WebApplicationContext} and 
 * prepares a {@link MockMvc} for the test methods.
 * 
 * @author Gareth
 *
 */
public abstract class AbstractControllerTest extends AbstractTest {
	
	protected MockMvc mvc;
	
	@Autowired
	protected WebApplicationContext webApplicationContext;
	
	/**
	 * Builds a {@link MockMvc} instance to be used in the web tests.
	 * Must be called in the {@code @Before} annotated method of the concrete unit test.
	 */
	protected void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	/**
     * Prepares the test class for execution of web tests. Builds a MockMvc
     * instance using standalone configuration, facilitating the injection of
     * Mockito resources into the controller class.
     * 
     * @param controller the controller object to be tested.
     */
	protected void setUp(BaseController controller) {
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	/**
     * Maps an Object into a JSON String using a Jackson ObjectMapper.
     * 
     * @param obj the Object to map.
     * @return a String of JSON.
     * @throws JsonProcessingException Thrown if an error occurs while mapping.
     */
    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

    /**
     * Maps a String of JSON into an instance of a Class of type T using a
     * Jackson ObjectMapper.
     * 
     * @param json a String of JSON.
     * @param clazz a Class of type T. The mapper will attempt to convert the
     *        JSON into an Object of this Class type.
     * @return an Object of type T.
     * @throws JsonParseException Thrown if an error occurs while mapping.
     * @throws JsonMappingException Thrown if an error occurs while mapping.
     * @throws IOException Thrown if an error occurs while mapping.
     */
    protected <T> T mapFromJson(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, clazz);
    }
	
}
