package paik.jpa.example.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paik.jpa.example.entity.Post;
import paik.jpa.example.entity.User;
import paik.jpa.example.repository.PostRepository;
import paik.jpa.example.repository.UserRepository;

@Service
public class UserLogic {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	public List<User> getUserList() {
		return (List<User>) userRepository.findAll();
	}

	public User getUserByIdLogic(Long id) {
		return userRepository.findById(id).get();
	}

	public User addUserLogic(User user) {
		User usr = userRepository.save(user);
		return usr;
	}

	public User updateUserLogic(User user) {
		User usr = userRepository.save(user);
		return usr;
	}

	public Post postLogic(Post post, Long id) {
		
		// User retrival from db
		User user = userRepository.findByUserId(id);
		//System.out.println(user);
		if (user.getPosts() == null) {
			user.setPosts(new ArrayList<Post>());
		}
		
		// Update post from user data 
		post.setUserId(id);
		post.setUserName(user.getUserName());
		post.setUserId(id);
		
		// post to database
		Post pst = postRepository.save(post);
		user.getPosts().add(pst);
		System.out.println(user);
		
		// Update user info
		User usr = userRepository.save(user);
		return pst;
	}


}
