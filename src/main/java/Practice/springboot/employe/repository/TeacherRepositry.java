package Practice.springboot.employe.repository;

import Practice.springboot.employe.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface TeacherRepositry extends JpaRepository<Teacher, Long> {
}
