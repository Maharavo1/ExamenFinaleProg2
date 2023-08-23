package ExamenProg2.com.Prog2.Controller;

import ExamenProg2.com.Prog2.Service.CustomerService;
import ExamenProg2.com.Prog2.model.customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("customer")
    public List<customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/customerInsert")
    public void insertCustomer(@RequestBody customer toInsert) {
        customerService.insertCustomers(toInsert);
    }

    @GetMapping("/customerId/{id}")
    public customer getCustomerById(@PathVariable int id) {
        return customerService.getIdCustomers(id);
    }

    @PutMapping("/customerUpdate/{id}")
    public customer updateCustomer(@PathVariable int id, @RequestBody customer toUpdate) {
        return customerService.updateCustomers(id, toUpdate);
    }

    @DeleteMapping("/customerDelete/{id}")
    public List<customer> deleteCustomer(@PathVariable int id) {
        return customerService.deleteCustomers(id);
    }
}
