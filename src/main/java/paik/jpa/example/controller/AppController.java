package paik.jpa.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import paik.jpa.example.business.BusinessLogic;
import paik.jpa.example.entity.Student;

@RestController
public class AppController {

	@Autowired
	private BusinessLogic logic;
	
	@GetMapping("/student")
	public List<Student> getStudentList(){
		return logic.getStudentListLogic();
	}
	
	@PostMapping("/student/{id}")
	public String addStudentInfo(@RequestBody Student student,@PathVariable Long id) {
		System.out.println(student);
		logic.addNewStudent(student);
		return "Success";	
	}
}
