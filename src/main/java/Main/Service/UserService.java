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
	
	public User addUser (User user)  {
		return userRepo.save(user);
	}
	
	public User getUserById(int idUser) {
		return userRepo.getById(idUser);
	}
	
	
	public User updateUser (User user)  {
		return userRepo.save(user);
	}
	
	public void deleteUser(Integer id) {
		userRepo.deleteById(id);
	}
}
