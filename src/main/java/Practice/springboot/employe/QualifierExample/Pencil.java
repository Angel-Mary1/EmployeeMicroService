package Practice.springboot.employe.QualifierExample;

import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Pencil implements Writer{

    @Override
    public void write() {
        System.out.println("Pecil using");
    }
}