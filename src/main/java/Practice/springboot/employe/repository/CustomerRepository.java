package Practice.springboot.employe.repository;


import Practice.springboot.employe.dto.OrderResponseDTO;
import Practice.springboot.employe.entity.Customer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query( "SELECT new Practice.springboot.employe.dto.OrderResponseDTO( c.customerName, p.productName) FROM Customer c JOIN c.products p")
    public List<OrderResponseDTO> findAllOrders();

    // the hibernate N+1 problem can be resolved by below ways
    //1) using LEFT JOIN FETCH query

    @Query( "SELECT p From Customer p LEFT JOIN FETCH p.products")
    public List<Customer> findAllOrdersWihout_N_plusOneIssue();

    // 2) using EntityGraph
    @EntityGraph(attributePaths = ("products"))
    public List<Customer> findAll();

    // or you can use criteria like below•
    // Criteria criteria = session.createCriteria(Department.class);
    //criteria.setFetchMode("listOfEmployees",, FetchMode.EAGER):

}
