package Practice.springboot.employe.repository;

import Practice.springboot.employe.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositry extends JpaRepository<Employee, Long>
{

}
