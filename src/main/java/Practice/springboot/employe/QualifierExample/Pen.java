package Practice.springboot.employe.QualifierExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Pen implements Writer{

    @Override
    public void write() {
        System.out.println("Pen using");
    }



}
