package Main.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Main.Dto.User;
import Main.Repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	
	/**
	 * 
	 * @return userRepo.findAll()
	 */
	@Transactional(rollbackOn = Exception.class)
	public List<User> listAll() {
		return userRepo.findAll();
	}
	/**
	 * 
	 * @param payload
	 * @return response
	 * @throws Exception
	 */
	@Transactional(rollbackOn = Exception.class)
	public Map<String, Object> addUser (Map<String, String> payload) throws Exception {
		Map<String, Object> response = new HashMap<>();
		User user = new User();
		String firstName = payload.get("firstName");
		String lastName = payload.get("lastName");
		String email = payload.get("email");
		String password = payload.get("password");
		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		
		userRepo.save(user);
		
		response.put("created", true);
		response.put("message", "User added successfuly");
		response.put("user", user);

		return response;
	}
	/**
	 * 
	 * @param payload
	 * @return response
	 * @throws Exception
	 */
	@Transactional(rollbackOn = Exception.class)
	public Map<String, Object> updateUser (Integer id, Map<String, String> payload) throws Exception {
		Map<String, Object> response = new HashMap<>();
		
		// Check if exist by id
		Optional<User> optionalUser = userRepo.findById(id);
		User user = optionalUser.get();
		
		String firstName = payload.get("firstName");
		String lastName = payload.get("lastName");
		String email = payload.get("email");
		String password = payload.get("password");
		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		
		userRepo.save(user);
		
		response.put("created", true);
		response.put("message", "User updated successfuly");
		response.put("user", user);

		return response;
	}
	
	public void deleteUser(Integer id) {
		userRepo.deleteById(id);
	}
}
