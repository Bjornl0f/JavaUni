package lab6;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionTest {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.err.println("Unable to connect to the database. Error: " + e.getMessage());
        }
    }
}
