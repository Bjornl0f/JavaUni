package lab6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryServiceWithStream implements LibraryServiceInterface {

    private final Library library;

    public LibraryServiceWithStream(Library library) {
        this.library = library;
    }

    @Override
    public List<Book> filterAuthorsAndBooksByPartName(String initials) {
        String initialsLowerCase = initials.toLowerCase();
        return library.getBooks().stream()
                .filter(book -> book.getAuthor().getName().toLowerCase().startsWith(initialsLowerCase))
                .toList();
    }

    // Метод для сортування книг за роком випуску (за замовчуванням)
    @Override
    public List<Book> sortBooksByYear() {
        return library.getBooks().stream()
                .sorted(Comparator.comparing(Book::getYear))
                .toList();
    }

    // Метод для сортування книг за заголовком
    @Override
    public List<Book> sortBooksByTitle() {
        return library.getBooks().stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .toList();
    }

    @Override
    public List<Book> sortAuthorsByBirthDate() {
        List<Author> sortedAuthors = library.getBooks().stream()
                .map(Book::getAuthor)
                .distinct()
                .sorted(Comparator.comparing(Author::getBirthDate))
                .collect(Collectors.toList());

        System.out.println("Authors sorted by Birth Date:");
        List<Book> result = new ArrayList<>();
        for (Author author : sortedAuthors) {
            result.addAll(getBooksByAuthor(author));
        }
        return result;
    }

    private List<Book> getBooksByAuthor(Author author) {
        return library.getBooks().stream()
                .filter(book -> book.getAuthor().equals(author))
                .toList();
    }


    // Допоміжний метод для виведення списку книг
    @Override
    public void displayBooks(String message, List<Book> books) {
        System.out.println(message);
        books.forEach(book -> System.out.println(book.getTitle() + " - " + book.getYear()));
    }

    public void addBookToLibrary(Book book) {
        library.addBook(book);
    }

    public List<Book> getAllBooks() {
        return library.getBooks();
    }
}
