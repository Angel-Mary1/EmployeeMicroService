package Practice.springboot.employe.service;

import Practice.springboot.employe.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    public StudentDTO createStudent(StudentDTO employeeDTO);

    public StudentDTO getStudentById(Long employeeId);

    public List<StudentDTO> getAllStudents();


    public void sendEmail(Long employeeId);

    StudentDTO getStudentByIdAndName(Long studentId, String studentName);

    StudentDTO getStudentByIdOrLastName(Long studentId, String studentLastName);

    List<StudentDTO> top3By(String by);
}
