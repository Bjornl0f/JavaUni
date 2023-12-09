package lab6;

import java.util.List;

public interface LibraryServiceInterface {

    List<Book> filterAuthorsAndBooksByPartName(String initials);

    // Метод для сортування книг за роком випуску (за замовчуванням)
    List<Book> sortBooksByYear();

    // Метод для сортування книг за заголовком
    List<Book> sortBooksByTitle();

    List<Book> sortAuthorsByBirthDate();

    // Допоміжний метод для виведення списку книг
    void displayBooks(String message, List<Book> books);
}