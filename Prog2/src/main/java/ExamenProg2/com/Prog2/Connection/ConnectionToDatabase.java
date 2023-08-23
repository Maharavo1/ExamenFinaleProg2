package ExamenProg2.com.Prog2.Connection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class ConnectionToDatabase {
    @Bean
    public Connection getConnection() throws SQLException {
        String dbUrl = "jdbc:postgresql://localhost:5432/prog2";
        String dbUsername = "postgres";
        String dbPassword = "root";

        return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    }
}
