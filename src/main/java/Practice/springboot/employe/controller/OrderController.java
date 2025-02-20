package Practice.springboot.employe.controller;

import Practice.springboot.employe.dto.OrderResponseDTO;
import Practice.springboot.employe.entity.Customer;
import Practice.springboot.employe.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    private  OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/get/all")
    public List<Customer> getAllCustomers(){

        return orderService.findAllCustomers();
    }

    @GetMapping("/get/customer")
    public List<Customer> getAllCustomer(){

        return orderService.findAllCustomer();
    }

    @PostMapping ("/add/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) throws Exception{

        return new ResponseEntity<>(orderService.createCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping("/get/orderresponse")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<OrderResponseDTO>> findAllOrders() {

        return new ResponseEntity<>(orderService.findAllOrders(), HttpStatus.CREATED);
    }
}
