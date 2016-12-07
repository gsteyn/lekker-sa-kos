package steyn.gareth.lekkersakos.rest;

import java.util.Map;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import steyn.gareth.lekkersakos.exception.ExceptionAttributes;

/**
 * This class implements common functionality for all Controller
 * classes. The {@code @ExceptionHandler} methods provide a consistent
 * response when Exceptions are thrown from {@code @RequestMapping}
 * annotated Controller methods.
 * 
 * @author Gareth 
 */
public class BaseController {

	static final Logger logger = LogManager.getLogger(BaseController.class.getName());
	
	/**
     * Handles JPA {@link NoResultExceptions} thrown from controller methods. 
     * It creates a response with {@link ExceptionAttributes} as JSON and HTTP
     * status code 404, not found.
     * 
     * @param exception a NoResultException instance.
     * @param request the HttpServletRequest in which the NoResultException was
     *        raised.
     * @return a ResponseEntity containing {@link ExceptionAttributes} in the body
     *         and HTTP status code 404.
     */
	@ExceptionHandler(NoResultException.class)
    public ResponseEntity<Map<String, Object>> handleNoResultException(
            NoResultException exception, HttpServletRequest request) {

        logger.info("> handleNoResultException");

        ExceptionAttributes exceptionAttributes = new ExceptionAttributes();

        Map<String, Object> responseBody = exceptionAttributes
                .getExceptionAttributes(exception, request,
                        HttpStatus.NOT_FOUND);

        logger.info("< handleNoResultException");
        return new ResponseEntity<Map<String, Object>>(responseBody,
                HttpStatus.NOT_FOUND);
    }
	
	/**
     * Handles all Exceptions not addressed by more specific {@code @ExceptionHandler} methods. 
     * Creates a response with the {@link ExceptionAttributes} in the response body as JSON and a HTTP status code
     * of 500, internal server error.
     * 
     * @param exception an Exception instance.
     * @param request The HttpServletRequest in which the Exception was raised.
     * @return A ResponseEntity containing {@link ExceptionAttributes} in the body
     *         and a HTTP status code 500.
     */
	@ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleException(
            Exception exception, HttpServletRequest request) {

        logger.error("> handleException");
        logger.error("- Exception: ", exception);

        ExceptionAttributes exceptionAttributes = new ExceptionAttributes();

        Map<String, Object> responseBody = exceptionAttributes
                .getExceptionAttributes(exception, request,
                        HttpStatus.INTERNAL_SERVER_ERROR);

        logger.error("< handleException");
        return new ResponseEntity<Map<String, Object>>(responseBody,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
}
