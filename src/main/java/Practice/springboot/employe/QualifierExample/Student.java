package Practice.springboot.employe.QualifierExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

    @Autowired
    @Qualifier("pen")
    private Writer writer;

    @Value("${server.port}")
    private String port;

    public void show()
    {
        System.out.println("Showing");
    }

    public void writeStudent()
    {
        System.out.println("value example"+port);
        writer.write();
    }
}
