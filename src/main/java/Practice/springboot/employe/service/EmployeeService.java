package Practice.springboot.employe.service;

import Practice.springboot.employe.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    public EmployeeDTO getEmployeeById(Long employeeId);

    public List<EmployeeDTO> getAllEmployees();


    public void sendEmail(Long employeeId);
}
