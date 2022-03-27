package paik.jpa.example.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import paik.jpa.example.business.UserLogic;
import paik.jpa.example.entity.Post;
import paik.jpa.example.entity.User;

@RestController
public class UserController {
	
	@Autowired
	private UserLogic userlogic;
	
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getUserList(){
		
		List<User> list = new ArrayList<User>();
		list = userlogic.getUserList();
		ResponseEntity<List<User>> responseEntity = new ResponseEntity<List<User>>(list,HttpStatus.OK);
		/*
		 * for (Iterator iterator = list.iterator(); iterator.hasNext();) { User user =
		 * (User) iterator.next(); System.out.println(user); }
		 */
		return responseEntity;
		
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id){
		User user = userlogic.getUserByIdLogic(id);
		ResponseEntity<User> responseEntity = new ResponseEntity<User>(user,HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping("/user/saveuser")
	public ResponseEntity<User> addUser(@RequestBody User user){
		//System.out.println(user);
		if(user.getUserId()!=null) {
			return new ResponseEntity<User>(new User(),HttpStatus.BAD_REQUEST); 
		}
		User isAdded = userlogic.addUserLogic(user);
		//System.out.println(isAdded);
		ResponseEntity<User> responseEntity = new ResponseEntity<User>(isAdded,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PostMapping("/user/updateuser")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		//System.out.println(user);
		if(user.getUserId()==null) {
			return new ResponseEntity<User>(new User(),HttpStatus.BAD_REQUEST); 
		}
		User result = userlogic.updateUserLogic(user);
		//System.out.println(result);
		ResponseEntity<User> responseEntity = new ResponseEntity<User>(result,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PostMapping("/user/{id}/post")
	public ResponseEntity<Post> addPost(@RequestBody Post post,@PathVariable Long id){
		//System.out.println(post);
		Post result = userlogic.postLogic(post,id);
		//System.out.println(result);
		ResponseEntity<Post> responseEntity = new ResponseEntity<Post>(result,HttpStatus.CREATED);
		return responseEntity;
	}
}
