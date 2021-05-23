package Main.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Main.Dto.User;

import Main.Service.UserService;

@RestController
@RequestMapping(path = "RESTAPI")
public class UserController {
	private static final Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@GetMapping(path = "/hello")
	public void SayHello() {
	 logger.info("Hello there...");
	}
	
	/**
	 * 
	 * @return userServive.listAll()
	 */
	@GetMapping(path = "/user/getAll")
	public List<User> getAllUsers() {
		logger.info("getAllUsers...");

		return userService.listAll();
	}
	
	@PostMapping(path = "/user/add")
    public ResponseEntity<Map<String, Object>> addUser(@RequestBody Map<String, String> payload){
		Map<String, Object> response = new HashMap<>();
		
        try {
			if (payload != null) {
				response = userService.addUser(payload);
				return new ResponseEntity<>(response, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

		} catch (IllegalArgumentException e) {
			logger.error("Error receiving parameters", e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error("Error when saving object User. ", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

	/**
	 * 
	 * @param id
	 * @param payload
	 * @return response
	 */
	@PutMapping(path = "/user/{id}")
	public ResponseEntity<Map<String, Object>> updateUser(@PathVariable Integer id,
			@RequestBody Map<String, String> payload) {
		logger.info("update an existing user...");
		Map<String, Object> response = new HashMap<>();
		
		try {

			response = userService.updateUser(id, payload);

			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			logger.error("Error getting User Object ", e);
			response.clear();
			response.put("Error", "User [" + id + "] no existe");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		} catch (IllegalArgumentException e) {
			logger.error("Error receiving parameters", e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error("Error getting userId ", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @DeleteMapping(path = "/user/{id}")
    public void deleteUser (@PathVariable Integer id){
    	logger.info("deleting user...");

    	userService.deleteUser(id);
 	
    }

}
