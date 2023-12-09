package lab6;

import java.time.LocalDate;
import serialization.EntitySerialization;
import serialization.JsonEntitySerialization;
import serialization.XmlEntitySerialization;
import serialization.TxtEntitySerialization;

import java.io.IOException;
import java.util.List;


// Головний клас
public class MainLib {
    public static void main(String[] args) {
        // Створюємо автора за допомогою Builder
        Author author1 = new AuthorBuilder()
                .setName("John Mayer")
                .setBirthDate(LocalDate.of(1980, 1, 1))
                .build();

        // Створюємо книгу за допомогою Builder
        Book book1 = new BookBuilder()
                .setTitle("Джава для початківців")
                .setAuthor(author1)
                .setYear(2000)
                .build();

        String address = "Київ, вул. Шевченка";

        // Створюємо бібліотеку і додаємо книги та адресу
        Library library = new Library();
        library.addBook(book1);
        library.setAddress(address);

        // Виводимо інформацію про бібліотеку
        System.out.println(library);
    }
}

