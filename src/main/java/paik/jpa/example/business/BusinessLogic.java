package paik.jpa.example.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paik.jpa.example.entity.Student;
import paik.jpa.example.repository.StudentRepository;

@Service
public class BusinessLogic {
	
	@Autowired
	private StudentRepository repository;
	
	public List<Student> getStudentListLogic(){
		return (List<Student>) repository.findAll();
	}
	
	public void addNewStudent(Student student) {
		repository.save(student);
	}
}
