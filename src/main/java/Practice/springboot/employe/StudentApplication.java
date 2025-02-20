package Practice.springboot.employe;

import Practice.springboot.employe.QualifierExample.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args)
	{


		ApplicationContext context = SpringApplication.run(StudentApplication.class, args);

		Student student= context.getBean(Student.class);
		student.writeStudent();
	}
}
