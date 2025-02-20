package Practice.springboot.employe.ServiceTest;

import Practice.springboot.employe.dto.StudentDTO;
import Practice.springboot.employe.entity.Student;
import Practice.springboot.employe.repository.StudentRepositry;
import Practice.springboot.employe.service.StudentService;
import Practice.springboot.employe.service.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StudentServiceTest {

    @InjectMocks
    StudentServiceImpl studentService;

    @Mock
    StudentRepositry studentRepositry;

    @Test
    public void findbyStudentId() {

      when(studentRepositry.findById(1L)).thenReturn(getStudent());

      StudentDTO output= studentService.getStudentById(1L);
      assertEquals(output.getId(),1L);
      assertEquals(output.getFirstName(),"Ange");
    }

    public Optional<Student> getStudent() {

        Student student = Student.builder().id(1L).firstName("Ange").lastName("Mary").build();
        return Optional.of(student) ;

    }
}
