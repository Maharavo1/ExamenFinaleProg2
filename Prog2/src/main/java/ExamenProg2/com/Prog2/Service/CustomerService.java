package ExamenProg2.com.Prog2.Service;

import ExamenProg2.com.Prog2.Repository.CustomerDAO;
import ExamenProg2.com.Prog2.model.customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerDAO customerDAO;


    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public List<customer> getAllCustomers() {
      return customerDAO.getAllCustomer();
    }

    public void insertCustomers(customer toInsert) {
        customerDAO.insertCustomer(toInsert);
    }

    public customer getIdCustomers(int id) {
       return customerDAO.getIdCustomer(id);
    }

    public customer updateCustomers(int id, customer toUpdate) {
       return customerDAO.updateCustomer(id,toUpdate);
    }

    public List<customer> deleteCustomers(int id) {
       return customerDAO.deleteCustomer(id);
    }
}
