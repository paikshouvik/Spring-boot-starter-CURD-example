package paik.jpa.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import paik.jpa.example.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{

}
