package Practice.springboot.employe.repository;


import Practice.springboot.employe.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepositry extends JpaRepository<Student, Long>
{

    Optional<Student> findByLastName(String lastName);
}
