package Main.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import Main.Dto.User;

import Main.Service.UserService;

@CrossOrigin (origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "RESTAPI")
public class UserController {
	private static final Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@GetMapping(path = "/user/{id}")
	public Optional<User> getUserById(@PathVariable("id") Integer id) {
	 return userService.getUserById(id);
	}
	
	@GetMapping(path = "/user/getAll")
	public List<User> getAllUsers() {
		logger.info("getAllUsers...");

		return userService.listAll();
	}
	
	@PostMapping(path = "user/add")
    public User addUser(@RequestBody User user ){
		return userService.addUser(user);
    }

	@PutMapping(path = "/user/{id}")
	public User updateUser(@RequestBody User user, @PathVariable("id") Integer id) {
			user.setIdUser(id);
			return userService.updateUser(user);
	}

    @DeleteMapping(path = "/user/{id}")
    public void deleteUser (@PathVariable("id") Integer id){
    	logger.info("deleting user...");

    	userService.deleteUser(id);
 	
    }

}
