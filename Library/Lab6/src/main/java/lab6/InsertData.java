package lab6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class InsertData {
    public static void insertBook(Book book) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO books (title, year, author_id) VALUES (?, ?, ?)")) {

            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setInt(2, book.getYear());
            preparedStatement.setInt(3, getAuthorId(book.getAuthor()));  // Set the author_id

            preparedStatement.executeUpdate();

            System.out.println("Book inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Helper method to get the author_id for a given author
    private static int getAuthorId(Author author) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT id FROM authors WHERE TRIM(name) = ? AND birth_date = ?")) {

            preparedStatement.setString(1, author.getName().trim());
            preparedStatement.setDate(2, java.sql.Date.valueOf(author.getBirthDate()));

            try (var resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id");
                } else {
                    throw new SQLException("Author not found in the database.");
                }
            }
        }
    }

    public static void insertAuthor(Author author) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO authors (name, birth_date) VALUES (?, ?)")) {

            preparedStatement.setString(1, author.getName());
            preparedStatement.setDate(2, java.sql.Date.valueOf(author.getBirthDate()));

            preparedStatement.executeUpdate();

            System.out.println("Author inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertLibraryAddress(String address) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO library (address) VALUES (?)")) {

            preparedStatement.setString(1, address);

            preparedStatement.executeUpdate();

            System.out.println("Library address inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Author author1 = new AuthorBuilder()
                .setName("John Doe")
                .setBirthDate(LocalDate.of(1980, 5, 15))
                .build();

        Author author2 = new AuthorBuilder()
                .setName("Jane Smith")
                .setBirthDate(LocalDate.of(1975, 8, 20))
                .build();

        Book book1 = new BookBuilder()
                .setTitle("Introduction to Programming")
                .setAuthor(author1)
                .setYear(2000)
                .build();

        Book book2 = new BookBuilder()
                .setTitle("Data Structures and Algorithms")
                .setAuthor(author1)
                .setYear(2005)
                .build();

        Book book3 = new BookBuilder()
                .setTitle("Java Programming")
                .setAuthor(author2)
                .setYear(2010)
                .build();

        Book book4 = new BookBuilder()
                .setTitle("Web Development Basics")
                .setAuthor(author2)
                .setYear(2015)
                .build();

        Author author3 = new AuthorBuilder()
                .setName("Alice Johnson")
                .setBirthDate(LocalDate.of(1990, 3, 10))
                .build();

        Author author4 = new AuthorBuilder()
                .setName("Bob Miller")
                .setBirthDate(LocalDate.of(1985, 7, 5))
                .build();

        Book book5 = new BookBuilder()
                .setTitle("Python Programming")
                .setAuthor(author3)
                .setYear(2012)
                .build();

        Book book6 = new BookBuilder()
                .setTitle("Machine Learning Basics")
                .setAuthor(author3)
                .setYear(2017)
                .build();

        Book book7 = new BookBuilder()
                .setTitle("JavaScript Fundamentals")
                .setAuthor(author4)
                .setYear(2013)
                .build();

        Book book8 = new BookBuilder()
                .setTitle("Mobile App Development")
                .setAuthor(author4)
                .setYear(2019)
                .build();

        String libraryAddress = "Holovna 6a, Chernivtsi";

        insertBook(book1);
        insertBook(book2);
        insertBook(book3);
        insertBook(book4);
        insertBook(book5);
        insertBook(book6);
        insertBook(book7);
        insertBook(book8);

        insertAuthor(author1);
        insertAuthor(author2);
        insertAuthor(author3);
        insertAuthor(author4);

        insertLibraryAddress(libraryAddress);
    }
}

