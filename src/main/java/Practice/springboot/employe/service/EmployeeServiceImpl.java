package Practice.springboot.employe.service;

import Practice.springboot.employe.EmailSenderService;
import Practice.springboot.employe.EmployeApplication;
import Practice.springboot.employe.dto.EmployeeDTO;
import Practice.springboot.employe.entity.Employee;
import Practice.springboot.employe.exception.ResourceNotFoundException;
import Practice.springboot.employe.mapper.EmployeeMapper;
import Practice.springboot.employe.repository.EmployeeRepositry;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements  EmployeeService{

    private EmployeeRepositry employeeRepositry;



    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        Employee savedEmployee= employeeRepositry.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(savedEmployee);

    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
      Employee employee= employeeRepositry.findById(employeeId).orElseThrow(
              ()->new ResourceNotFoundException("invalid id: "+ employeeId ) );
       return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeDTO> employeeDTOList = new ArrayList<EmployeeDTO>();
       List<Employee> employeeList = employeeRepositry.findAll();
       for(Employee employee:employeeList)
       {
           employeeDTOList.add(EmployeeMapper.mapToEmployeeDTO(employee));
       }
      return employeeDTOList;

       // Alternate way
       // return employeeList.stream().map(employee -> EmployeeMapper.mapToEmployeeDTO(employee)).collect(Collectors.toList());
    }


    @Override
    public void sendEmail( Long employeeId)
    {
        Employee employee = employeeRepositry.findById( employeeId ).orElseThrow(
                ()-> new ResourceNotFoundException( "invalid id"+ employeeId));
        EmailSenderService emailSenderService = new EmailSenderService();

        emailSenderService.sendEmail( employee.getEmailId() );
    }
}
