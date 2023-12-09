package lab6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryService implements LibraryServiceInterface {

    private final Library library;

    public LibraryService(Library library) {
        this.library = library;
    }

    @Override
    public List<Book> filterAuthorsAndBooksByPartName(String initials) {
        String initialsLowerCase = initials.toLowerCase();
        List<Book> filteredBooks = new ArrayList<>();

        for (Book book : library.getBooks()) {
            String authorName = book.getAuthor().getName().toLowerCase();

            if (authorName.startsWith(initialsLowerCase)) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

    @Override
    public List<Book> sortBooksByYear() {
        List<Book> sortedBooks = new ArrayList<>(library.getBooks());
        Collections.sort(sortedBooks, Comparator.comparingInt(Book::getYear));
        return sortedBooks;
    }

    @Override
    public List<Book> sortBooksByTitle() {
        List<Book> sortedBooks = new ArrayList<>(library.getBooks());
        Collections.sort(sortedBooks, Comparator.comparing(Book::getTitle));
        return sortedBooks;
    }

    @Override
    public List<Book> sortAuthorsByBirthDate() {
        List<Author> allAuthors = new ArrayList<>();
        for (Book book : library.getBooks()) {
            Author author = book.getAuthor();
            if (!allAuthors.contains(author)) {
                allAuthors.add(author);
            }
        }

        Collections.sort(allAuthors, Comparator.comparing(Author::getBirthDate));

        List<Book> result = new ArrayList<>();
        for (Author author : allAuthors) {
            result.addAll(getBooksByAuthor(author));
        }
        return result;
    }

    private List<Book> getBooksByAuthor(Author author) {
        List<Book> books = new ArrayList<>();
        for (Book book : library.getBooks()) {
            if (book.getAuthor().equals(author)) {
                books.add(book);
            }
        }
        return books;
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
