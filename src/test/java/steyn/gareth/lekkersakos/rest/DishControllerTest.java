package steyn.gareth.lekkersakos.rest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import steyn.gareth.lekkersakos.AbstractControllerTest;

/**
 * Unit tests for the DishController using Spring MVC Mocks. 
 * 
 * The test uses the Spring MVC Mock objects to simulate sending actual
 * HTTP requests to the Controller component. This test ensures that the
 * RequestMappings are configured correctly. Also, these tests ensure that the
 * request and response bodies are serialized as expected.
 * 
 * (For future proof you can add @Transactional which will revert all database
 * changes after the tests have been executed.)
 * 
 * @author Gareth
 */
public class DishControllerTest extends AbstractControllerTest {
		
	@Before
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void testFindAll() throws Exception {
		String uri = "/api/dishes";
        
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON)).andReturn();
		
		String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();
        
        Assert.assertEquals("failure -> expected HTTP status", 200, status);
        Assert.assertTrue(
                "failure -> expected HTTP response body to have a value",
                content.trim().length() > 0);
	}
	
}
