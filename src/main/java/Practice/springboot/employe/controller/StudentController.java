package Practice.springboot.employe.controller;

import Practice.springboot.employe.dto.StudentDTO;
import Practice.springboot.employe.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/student")
public class StudentController {


    @Autowired
    private StudentService studentService;

    @PostMapping()
    public ResponseEntity<StudentDTO> createEmployee(@RequestBody StudentDTO studentDTO)
    {
        StudentDTO saveStudent= studentService.createStudent(studentDTO);
        return new ResponseEntity<>(saveStudent, HttpStatus.CREATED );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getEmployeeById(@PathVariable("id") Long employeeid )
    {
        StudentDTO employeeDTO=studentService.getEmployeeById(employeeid);
        return ResponseEntity.ok(employeeDTO);
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllEmployee()
    {
       List<StudentDTO> employeeDTOList= studentService.getAllEmployees();
        return new ResponseEntity<>(employeeDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}/send/mail")
    public ResponseEntity<String> sendEmail(@PathVariable("id") Long employeeid)
    {

        studentService.sendEmail(employeeid);
        return new ResponseEntity<>("mail sent", HttpStatus.OK);
    }
}
