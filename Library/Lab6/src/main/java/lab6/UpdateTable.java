package lab6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class UpdateTable {
    public static void updateAuthor(int authorId, Author newAuthor) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String updateAuthor = "UPDATE authors SET name = ?, birth_date = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateAuthor)) {
                preparedStatement.setString(1, newAuthor.getName());
                preparedStatement.setString(2, newAuthor.getBirthDate().toString());
                preparedStatement.setInt(3, authorId);
                preparedStatement.executeUpdate();
                System.out.println("Author updated successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateBook(int bookId, Book newBook) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String updateBook = "UPDATE books SET title = ?, year = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateBook)) {
                preparedStatement.setString(1, newBook.getTitle());
                preparedStatement.setInt(2, newBook.getYear());
                preparedStatement.setInt(3, bookId);
                preparedStatement.executeUpdate();
                System.out.println("Book updated successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Author newAuthor = new AuthorBuilder()
                .setName("New Author Name")
                .setBirthDate(LocalDate.parse("1990-01-01"))
                .build();

        Book newBook = new BookBuilder()
                .setTitle("New Book Title")
                .setAuthor(newAuthor)
                .setYear(2022)
                .build();

        updateAuthor(1, newAuthor);
        updateBook(1, newBook);
    }
}
