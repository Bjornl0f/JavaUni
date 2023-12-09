package lab6;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTable {
    public static void dropTables() {
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            // SQL-запит для видалення таблиці книг
            String dropBooksTable = "DROP TABLE IF EXISTS books";

            // SQL-запит для видалення таблиці авторів
            String dropAuthorsTable = "DROP TABLE IF EXISTS authors";

            // SQL-запит для видалення таблиці бібліотеки
            String dropLibraryTable = "DROP TABLE IF EXISTS library";

            // Виконуємо SQL-запити для видалення таблиць у зворотньому порядку (спочатку books, потім authors, потім library)
            statement.executeUpdate(dropBooksTable);
            statement.executeUpdate(dropAuthorsTable);
            statement.executeUpdate(dropLibraryTable);

            System.out.println("Tables dropped successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        dropTables();
    }
}

