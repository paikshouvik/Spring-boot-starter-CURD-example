package paik.jpa.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import paik.jpa.example.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	
	public User findByUserId(Long id);
	
	
}
