package lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private String address;

    public Library() {
        this.books = new ArrayList<>();
        this.address = "";
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    // Методи для пошуку книг за різними критеріями

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Library)) return false;
        Library library = (Library) o;
        return Objects.equals(books, library.books) &&
                Objects.equals(address, library.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books, address);
    }

    // Сервісний метод для сортування книг за роком видання (використання Comparable)
    public List<Book> sortBooksByYear() {
        return books.stream()
                .sorted(Comparator.comparingInt(Book::getYear))
                .collect(Collectors.toList());
    }

    // Сервісний метод для сортування книг за ім'ям автора (використання Comparator)
    public void sortBooksByAuthorName() {
        Comparator<Book> byAuthorName = Comparator.comparing(book -> book.getAuthor().getName());
        Collections.sort(books, byAuthorName);
    }

    // Сервісний метод для фільтрації книг за певним автором
    public List<Book> filterBooksByAuthor(String authorName) {
        return books.stream()
                .filter(book -> book.getAuthor().getName().equals(authorName))
                .toList();
    }

    // Сервісний метод для отримання списку усіх унікальних авторів
    public List<String> getAllUniqueAuthors() {
        return books.stream()
                .map(book -> book.getAuthor().getName())
                .distinct()
                .toList();
    }

    // Сервісний метод для отримання книг за певним критерієм використовуючи Stream API
    public List<Book> getBooksByCriteria(String criteria) {
        return books.stream()
                .filter(book -> book.getTitle().contains(criteria) || book.getAuthor().getName().contains(criteria))
                .toList();
    }
}

