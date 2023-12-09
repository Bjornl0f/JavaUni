package serialization;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lab6.Library;
import lab6.Book;
import lab6.Author;

public class TxtEntitySerialization<T> implements EntitySerialization<T> {
    @Override
    public void serialize(List<T> entities, String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (T entity : entities) {
            if (entity instanceof Library) {
                Library library = (Library) entity;
                for (Book book : library.getBooks()) {
                    sb.append("Book name: ").append(book.getTitle()).append(", ")
                            .append("publish year: ").append(book.getYear()).append(", ")
                            .append("author name: ").append(book.getAuthor().getName()).append(", ")
                            .append("author birthdate: ").append(book.getAuthor().getBirthDate()).append("\n");
                }
            }
        }
        Files.write(Paths.get(filePath), sb.toString().getBytes());
    }



    @Override
    public List<T> deserialize(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        List<T> entities = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(", ");
            if (parts.length == 4) {
                String title = extractValue(parts[0]);
                int year = Integer.parseInt(extractValue(parts[1]));
                String authorName = extractValue(parts[2]);
                String birthDate = extractValue(parts[3]);

                Author author = new Author(authorName, LocalDate.parse(birthDate));
                Book book = new Book(title, author, year);
                entities.add((T) book);
            }
        }

        return entities;
    }

    private String extractValue(String part) {
        return part.split(": ")[1];
    }


}
