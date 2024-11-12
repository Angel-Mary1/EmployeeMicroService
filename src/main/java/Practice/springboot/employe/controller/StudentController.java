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
   //pathvariable --> only can use the same naming in the url
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id)
    {
        log.info("Interceptor hit the controller");
        StudentDTO employeeDTO=studentService.getStudentById(id);

        return ResponseEntity.ok(employeeDTO);
    }

    //multiplePath path variable & with value--> You can customize your variable name

    @GetMapping("/{id}/{name}")
    public ResponseEntity<StudentDTO> getStudentByIdAndName(@PathVariable("id") Long studentId ,
                                                            @PathVariable(value = "name") String studentName )
    {
        StudentDTO student=studentService.getStudentByIdAndName(studentId,studentName );
        return ResponseEntity.ok(student);
    }


    // With required false
    @GetMapping("/{id}/{lastname}/last")
    public ResponseEntity<StudentDTO> getStudentByIdOrLastName(
            @PathVariable("id") Long id,
            @PathVariable(value = "lastname") String studentLastName) {

        StudentDTO student = studentService.getStudentByIdOrLastName(id, studentLastName);
        return ResponseEntity.ok(student);
    }

    //RequestParam sample
    // sorting Student  by id, firstName, or lastName in ascending order by using requestparam
    @GetMapping(value = "/top3")
    public ResponseEntity<List<StudentDTO>> getTop3By( @RequestParam(required = false) String by) {
        try {
            List<StudentDTO> top3Events = studentService.top3By(by);
            return new ResponseEntity<>(top3Events, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping()
    public ResponseEntity<StudentDTO> createEmployee(@RequestBody StudentDTO studentDTO)
    {
        StudentDTO saveStudent= studentService.createStudent(studentDTO);
        return new ResponseEntity<>(saveStudent, HttpStatus.CREATED );
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents()
    {
       List<StudentDTO> employeeDTOList= studentService.getAllStudents();
        return new ResponseEntity<>(employeeDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}/send/mail")
    public ResponseEntity<String> sendEmail(@PathVariable("id") Long employeeid)
    {

        studentService.sendEmail(employeeid);
        return new ResponseEntity<>("mail sent", HttpStatus.OK);
    }
}
