package Practice.springboot.employe.service;

import Practice.springboot.employe.entity.Address;
import Practice.springboot.employe.repository.AddressRepositry;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

@Service
public class AddressService {

    @Autowired
    private AddressRepositry addressRepositry;

    //@Transactional
    public void addAdressToo(Address address) {

        //2nd crudn operation
        addressRepositry.save(address);

    }
}
