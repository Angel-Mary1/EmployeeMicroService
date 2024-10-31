package Practice.springboot.employe.service;

import Practice.springboot.employe.EmailSenderService;
import Practice.springboot.employe.dto.StudentDTO;

import Practice.springboot.employe.entity.Student;
import Practice.springboot.employe.exception.ResourceNotFoundException;

import Practice.springboot.employe.mapper.StudentMapper;

import Practice.springboot.employe.repository.StudentRepositry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepositry studentRepositry;



    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = StudentMapper.mapToStudent(studentDTO);
        Student savedStudent= studentRepositry.save(student);
        return StudentMapper.mapToStudentDTO(savedStudent);

    }

    @Override
    public StudentDTO getEmployeeById(Long employeeId) {
        Student employee= studentRepositry.findById(employeeId).orElseThrow(
              ()->new ResourceNotFoundException("invalid id: "+ employeeId ) );
       return StudentMapper.mapToStudentDTO(employee);
    }

    @Override
    public List<StudentDTO> getAllEmployees() {
        List<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();
       List<Student> employeeList = studentRepositry.findAll();
       for(Student student:employeeList)
       {
           studentDTOList.add(StudentMapper.mapToStudentDTO(student));
       }
      return studentDTOList;

       // Alternate way
       // return employeeList.stream().map(employee -> EmployeeMapper.mapToEmployeeDTO(employee)).collect(Collectors.toList());
    }


    @Override
    public void sendEmail( Long studentId)
    {
        Student employee = studentRepositry.findById( studentId ).orElseThrow(
                ()-> new ResourceNotFoundException( "invalid id"+ studentId));
        EmailSenderService emailSenderService = new EmailSenderService();

        emailSenderService.sendEmail( employee.getEmailId() );
    }
}
