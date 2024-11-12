package Practice.springboot.employe.controller;


import Practice.springboot.employe.entity.Teacher;
import Practice.springboot.employe.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/save")
    public ResponseEntity<?> addTeacher(@RequestBody Teacher teacher) throws Exception
    {

        Teacher savedTeacher= teacherService.addTeacher(teacher);
        return new ResponseEntity<Teacher>(savedTeacher, HttpStatus.CREATED);
    }

    @GetMapping ("/{id}")
    @ResponseBody
    public ResponseEntity<?> getTeacherById(@PathVariable("id") Long id) throws Exception
    {

        Teacher teacher= teacherService.getTeacherById(id);
        return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
    }

}
