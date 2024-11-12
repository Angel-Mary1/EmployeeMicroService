package Practice.springboot.employe.repository;

import Practice.springboot.employe.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepositry extends JpaRepository<Address, Long> {


}
