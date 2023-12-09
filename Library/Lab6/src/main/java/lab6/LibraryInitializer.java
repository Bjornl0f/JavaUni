package lab6;

import serialization.EntitySerialization;
import serialization.JsonEntitySerialization;
import serialization.TxtEntitySerialization;
import serialization.XmlEntitySerialization;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class LibraryInitializer {
    public static void main(String[] args) {
        // Створення об'єктів авторів
        Author author1 = new AuthorBuilder()
                .setName("John Doe")
                .setBirthDate(LocalDate.of(1980, 5, 15))
                .build();

        Author author2 = new AuthorBuilder()
                .setName("Jane Smith")
                .setBirthDate(LocalDate.of(1975, 8, 20))
                .build();

        // Створення об'єктів книг
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

        // Створення об'єкту бібліотеки та додавання книг
        Library library = new Library();
        LibraryService libraryService = new LibraryService(library);

        libraryService.addBookToLibrary(book1);
        libraryService.addBookToLibrary(book2);
        libraryService.addBookToLibrary(book3);
        libraryService.addBookToLibrary(book4);
        libraryService.addBookToLibrary(book5);
        libraryService.addBookToLibrary(book6);
        libraryService.addBookToLibrary(book7);
        libraryService.addBookToLibrary(book8);


        libraryService.displayBooks("\nAll Books: ", libraryService.getAllBooks());

        List<Book> sortedBooksByTitle = libraryService.sortBooksByTitle();
        libraryService.displayBooks("\nSorted Books by Title:", sortedBooksByTitle);

        List<Book> sortedBooksByYear = libraryService.sortBooksByYear();
        libraryService.displayBooks("\nSorted Books by Year:", sortedBooksByYear);

        List<Book> sortedAuthorsByBirthDate = libraryService.sortAuthorsByBirthDate();
        libraryService.displayBooks("\nAuthors sorted by Birth Date:", sortedAuthorsByBirthDate);

        List<Book> filteredBooksByInitials = libraryService.filterAuthorsAndBooksByPartName("J");
        libraryService.displayBooks("\nFiltered Books by Initials:", filteredBooksByInitials);

        // Серіалізація та десеріалізація для JSON
        EntitySerialization<Library> jsonSerialization = new JsonEntitySerialization<>();
        try {
            jsonSerialization.serialize(List.of(library), "D:\\Programming\\JavaUni\\Lab6\\library.json");
            List<Library> deserializedLibrariesJson = jsonSerialization.deserialize("D:\\Programming\\JavaUni\\Lab6\\library.json");
            System.out.println(deserializedLibrariesJson.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Серіалізація та десеріалізація для XML
        EntitySerialization<Library> xmlSerialization = new XmlEntitySerialization<>();
        try {
            xmlSerialization.serialize(List.of(library), "D:\\Programming\\JavaUni\\Lab6\\library.xml");
            List<Library> deserializedLibrariesXml = xmlSerialization.deserialize("D:\\Programming\\JavaUni\\Lab6\\library.xml");
            System.out.println(deserializedLibrariesXml.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Серіалізація та десеріалізація для TXT
        EntitySerialization<Library> txtSerialization = new TxtEntitySerialization<>();
        try {
            txtSerialization.serialize(List.of(library), "D:\\Programming\\JavaUni\\Lab6\\library.txt");
            List<Library> deserializedLibrariesTxt = txtSerialization.deserialize("D:\\Programming\\JavaUni\\Lab6\\library.txt");
            System.out.println(deserializedLibrariesTxt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
