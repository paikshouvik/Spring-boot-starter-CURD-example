package paik.jpa.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import paik.jpa.example.entity.Post;
import paik.jpa.example.entity.User;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
	
	public User findByPostId(Long id);
	
}
