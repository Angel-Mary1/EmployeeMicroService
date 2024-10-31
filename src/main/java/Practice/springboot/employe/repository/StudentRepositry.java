package Practice.springboot.employe.repository;


import Practice.springboot.employe.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositry extends JpaRepository<Student, Long>
{

}
