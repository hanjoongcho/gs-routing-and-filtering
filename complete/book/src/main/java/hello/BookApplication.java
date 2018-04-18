package hello;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BookApplication {
	private static Logger log = LoggerFactory.getLogger(BookApplication.class);
	
	@RequestMapping(value = "/available")
	public String available(HttpServletRequest request) {
		// curl -d "testParam=apple" -X POST  192.168.56.101:8080/books/available
	    log.info(String.format("%s request parameter %s", request.getMethod(), request.getParameter("testParam")));
		return "Spring in Action";
	}
	
	@RequestMapping(value = "/checked-out")
	public String checkedOut() {
		return "Spring Boot in Action";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}
}
