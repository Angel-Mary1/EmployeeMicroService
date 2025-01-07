package Practice.springboot.employe.service;

import Practice.springboot.employe.dto.OrderResponseDTO;
import Practice.springboot.employe.entity.Customer;
import Practice.springboot.employe.repository.CustomerRepository;
import Practice.springboot.employe.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private CustomerRepository customerRepository;
    private ProductRepository productRepository;

    public OrderService(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    public List<OrderResponseDTO> findAllOrders() {

        return customerRepository.findAllOrders();
    }


}
