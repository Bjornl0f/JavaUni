package lab6;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void createTables() {
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            // SQL-запит для створення таблиці авторів
            String createAuthorsTable = "CREATE TABLE IF NOT EXISTS authors (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(255) NOT NULL," +
                    "birth_date DATE NOT NULL)";

            // Виконуємо SQL-запит для створення таблиці авторів перед таблицею книг
            statement.executeUpdate(createAuthorsTable);

            // SQL-запит для створення таблиці книг
            String createBooksTable = "CREATE TABLE IF NOT EXISTS books (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "title VARCHAR(255) NOT NULL," +
                    "year INT NOT NULL," +
                    "author_id INT NOT NULL," +  // Add a new column for foreign key
                    "FOREIGN KEY (author_id) REFERENCES authors(id))";

            // Виконуємо SQL-запит для створення таблиці книг
            statement.executeUpdate(createBooksTable);

            // SQL-запит для створення таблиці бібліотеки
            String createLibraryTable = "CREATE TABLE IF NOT EXISTS library (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "address VARCHAR(255) NOT NULL)";

            // Виконуємо SQL-запит для створення таблиці бібліотеки
            statement.executeUpdate(createLibraryTable);

            System.out.println("Tables created successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createTables();
    }
}


