package Practice.springboot.employe.service;

import Practice.springboot.employe.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    public StudentDTO createStudent(StudentDTO employeeDTO);

    public StudentDTO getEmployeeById(Long employeeId);

    public List<StudentDTO> getAllEmployees();


    public void sendEmail(Long employeeId);
}
