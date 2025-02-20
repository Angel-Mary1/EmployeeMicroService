package Practice.springboot.employe.service;

import Practice.springboot.employe.dto.OrderResponseDTO;
import Practice.springboot.employe.entity.Customer;

import Practice.springboot.employe.repository.CustomerRepository;
import Practice.springboot.employe.repository.ProductRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    private CustomerRepository customerRepository;
    private ProductRepository productRepository;

    public OrderService(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }


   @Transactional(propagation = Propagation.REQUIRED)
    public Customer createCustomer(Customer customer) throws Exception{

        Customer newCustomer = customerRepository.save(customer);

        checkTransactionDummy();

        return newCustomer ;
    }

    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    public List<OrderResponseDTO> findAllOrders() {


        return customerRepository.findAllOrders();
    }

   @Transactional( propagation=Propagation.NEVER)
    public void checkTransactionDummy() throws Exception
    {
        int amount = productRepository.findAll().size();
    }




 }
