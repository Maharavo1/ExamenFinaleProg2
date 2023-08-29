package ExamenProg2.com.Prog2.Repository;

import ExamenProg2.com.Prog2.model.customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Repository
public abstract class CustomerDAO {
    public abstract List<customer> getAllCustomer();
    public abstract void insertCustomer(customer toInsert);
    public abstract customer getIdCustomer(int id);
    public abstract customer updateCustomer(int id, customer toUpdate);
    public abstract List<customer> deleteCustomer(int id);
}
