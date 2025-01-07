package Practice.springboot.employe.repository;


import Practice.springboot.employe.dto.OrderResponseDTO;
import Practice.springboot.employe.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query( "SELECT new Practice.springboot.employe.dto.OrderResponseDTO( c.customerName, p.productName) FROM Customer c JOIN c.products p")
    public List<OrderResponseDTO> findAllOrders();



}
