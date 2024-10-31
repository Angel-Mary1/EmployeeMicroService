package Practice.springboot.employe.mapper;

import Practice.springboot.employe.dto.StudentDTO;
import Practice.springboot.employe.entity.Student;

public class StudentMapper {

    public static Student mapToStudent(StudentDTO studentDTO) {

        return new Student( studentDTO.getId(), studentDTO.getFirstName(), studentDTO.getLastName(), studentDTO.getEmailId());
    }

    public static StudentDTO mapToStudentDTO(Student student) {

        return new StudentDTO( student.getId(), student.getFirstName(), student.getLastName(), student.getEmailId());
    }
}
