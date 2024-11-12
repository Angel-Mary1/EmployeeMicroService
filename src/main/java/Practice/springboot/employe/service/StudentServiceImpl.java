package Practice.springboot.employe.service;

import Practice.springboot.employe.EmailSenderService;
import Practice.springboot.employe.dto.StudentDTO;

import Practice.springboot.employe.entity.Student;
import Practice.springboot.employe.exception.ResourceNotFoundException;

import Practice.springboot.employe.mapper.StudentMapper;

import Practice.springboot.employe.repository.StudentRepositry;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepositry studentRepositry;


    @Override
    public StudentDTO getStudentByIdAndName(Long studentId, String studentName) {
        Student student = studentRepositry.findById(studentId)
                .filter(s -> s.getFirstName().equals(studentName))
                .orElseThrow(() -> new EntityNotFoundException("Student not found with ID and name"));

        return StudentMapper.mapToStudentDTO(student);
    }

    @Override
    public StudentDTO getStudentByIdOrLastName(Long studentId, String studentLastName) {
        Student student;

        if (studentId != null) {
            student = studentRepositry.findById(studentId)
                    .orElseGet(() -> studentRepositry.findByLastName(studentLastName)
                            .orElseThrow(() -> new EntityNotFoundException("Student not found with provided ID or last name")));
        } else {
            student = studentRepositry.findByLastName(studentLastName)
                    .orElseThrow(() -> new EntityNotFoundException("Student not found with last name: " + studentLastName));
        }

        return StudentMapper.mapToStudentDTO(student);
    }


    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = StudentMapper.mapToStudent(studentDTO);
        Student savedStudent= studentRepositry.save(student);
        return StudentMapper.mapToStudentDTO(savedStudent);

    }

    @Override
    public StudentDTO getStudentById(Long studentId) {
        Student employee= studentRepositry.findById(studentId).orElseThrow(
              ()->new ResourceNotFoundException("invalid id: "+ studentId ) );
       return StudentMapper.mapToStudentDTO(employee);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<StudentDTO> studentDTOList = new ArrayList<>();
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
    public List<StudentDTO> top3By(String by) {
        if (!by.equals("id") && !by.equals("firstName") && !by.equals("lastName")) {
            throw new IllegalArgumentException("Invalid attribute for sorting: " + by);
        }

        Sort sort = Sort.by(Sort.Direction.ASC, by);
        PageRequest pageRequest = PageRequest.of(0, 3, sort); // Top 3 in ascending order by the given field
        return studentRepositry.findAll(pageRequest)
                .getContent()
                .stream()
                .map(StudentDTO::new)
                .collect(Collectors.toList());
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
