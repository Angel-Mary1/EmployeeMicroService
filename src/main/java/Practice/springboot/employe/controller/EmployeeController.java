package Practice.springboot.employe.controller;

import Practice.springboot.employe.dto.EmployeeDTO;
import Practice.springboot.employe.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @PostMapping()
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO)
    {
        EmployeeDTO saveEmployee= employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeid )
    {
        EmployeeDTO employeeDTO=employeeService.getEmployeeById(employeeid);
        return ResponseEntity.ok(employeeDTO);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee()
    {
       List<EmployeeDTO> employeeDTOList= employeeService.getAllEmployees();
        return new ResponseEntity<>(employeeDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}/send/mail")
    public ResponseEntity<String> sendEmail(@PathVariable("id") Long employeeid)
    {

        employeeService.sendEmail(employeeid);
        return new ResponseEntity<>("mail sent", HttpStatus.OK);
    }
}
