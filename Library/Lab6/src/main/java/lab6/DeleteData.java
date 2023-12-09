package lab6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {
    public static void deleteBook(String title) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM books WHERE title = ?")) {

            preparedStatement.setString(1, title);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Book deleted successfully.");
            } else {
                System.out.println("Book with title '" + title + "' not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAuthor(String name) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM authors WHERE name = ?")) {

            preparedStatement.setString(1, name);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Author deleted successfully.");
            } else {
                System.out.println("Author with name '" + name + "' not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteLibraryAddress(String address) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM library WHERE address = ?")) {

            preparedStatement.setString(1, address);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Library address deleted successfully.");
            } else {
                System.out.println("Library address '" + address + "' not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAllBooks() {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM books")) {

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("All books deleted successfully.");
            } else {
                System.out.println("No books found to delete.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAllAuthors() {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM authors")) {

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("All authors deleted successfully.");
            } else {
                System.out.println("No authors found to delete.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAllLibraryAddresses() {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM library")) {

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("All library addresses deleted successfully.");
            } else {
                System.out.println("No library addresses found to delete.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        deleteAllBooks();
        deleteAllAuthors();
        deleteAllLibraryAddresses();
    }
}
