package Practice.springboot.employe.mapper;

import Practice.springboot.employe.dto.EmployeeDTO;
import Practice.springboot.employe.entity.Employee;

public class EmployeeMapper {

    public static Employee mapToEmployee(EmployeeDTO employeeDTO) {

        return new Employee( employeeDTO.getId(), employeeDTO.getFirstName(), employeeDTO.getLastName(), employeeDTO.getEmailId());
    }

    public static EmployeeDTO mapToEmployeeDTO(Employee employee) {

        return new EmployeeDTO( employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmailId());
    }
}
