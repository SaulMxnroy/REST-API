package Main.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import Main.Dto.User;

public interface UserRepository extends JpaRepository <User, Integer>{

}
