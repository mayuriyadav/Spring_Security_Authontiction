package Com.SecurityAuthontiction.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Com.SecurityAuthontiction.Entity.User;

public interface UserRepo  extends JpaRepository<User, Integer>{
 
	Optional<User>findByEmail(String email);
}
