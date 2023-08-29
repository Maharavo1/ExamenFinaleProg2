package ExamenProg2.com.Prog2.Repository;

import ExamenProg2.com.Prog2.model.customer;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerCrud extends CustomerDAO {
    private Connection connection;

    public CustomerCrud(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<customer> getAllCustomer() {
        List<customer> allCustomers = new ArrayList<>();
        String sql = "SELECT * FROM customer";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                allCustomers.add(new customer(
                        result.getInt("customer_id"),
                        result.getString("name"),
                        result.getString("first_name"),
                        result.getString("adress"),
                        result.getString("email"),
                        result.getString("phone")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCustomers;
    }

    @Override
    public void insertCustomer(customer toInsert) {
        String sql = "INSERT INTO customer (name, first_name, adress, email, phone) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, toInsert.getName());
            preparedStatement.setString(2, toInsert.getFirst_name());
            preparedStatement.setString(3, toInsert.getAdress());
            preparedStatement.setString(4, toInsert.getEmail());
            preparedStatement.setString(5, toInsert.getPhone());

            int insertCustom = preparedStatement.executeUpdate();
            if (insertCustom > 0) {
                System.out.println("Insertion réussie : " + insertCustom);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public customer getIdCustomer(int id) {
        String sql = "SELECT * FROM customer WHERE customer_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                return new customer(
                        result.getInt("customer_id"),
                        result.getString("name"),
                        result.getString("first_name"),
                        result.getString("adress"),
                        result.getString("email"),
                        result.getString("phone")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public customer updateCustomer(int id, customer toUpdate) {
        String sql = "UPDATE customer SET name=?, first_name=?, adress=?, email=?, phone=? WHERE customer_id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, toUpdate.getName());
            preparedStatement.setString(2, toUpdate.getFirst_name());
            preparedStatement.setString(3, toUpdate.getAdress());
            preparedStatement.setString(4, toUpdate.getEmail());
            preparedStatement.setString(5, toUpdate.getPhone());
            preparedStatement.setInt(6, id);

            int updateCustom = preparedStatement.executeUpdate();
            if (updateCustom > 0) {
                System.out.println("Mise à jour réussie : " + updateCustom);
            }
            return toUpdate;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<customer> deleteCustomer(int id) {
        String sql = "DELETE FROM customer WHERE customer_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            int deleteCustom = preparedStatement.executeUpdate();
            if (deleteCustom > 0) {
                System.out.println("Suppression réussie : " + deleteCustom);
            }
            return getAllCustomer();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
