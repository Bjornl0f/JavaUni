package lab6;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;
import java.util.stream.Collectors;

// Клас Builder для книги
public class BookBuilder {
    private static final int MIN_YEAR = 1950;
    private static final int MAX_YEAR = 2022;

    @NotNull
    @NotBlank
    private String title;

    @NotNull
    private Author author;

    @Min(value = MIN_YEAR, message = "Year must be greater than or equal to {value}")
    @Max(value = MAX_YEAR, message = "Year must be less than or equal to {value}")
    private int year;

    public BookBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public BookBuilder setYear(int year) {
        this.year = year;
        return this;
    }

    public Book build() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<BookBuilder>> constraintViolations =
                    validator.validate( this );

        if (constraintViolations.isEmpty()) {
            return new Book(title, author, year);
        }

        else {
            String violationsMessage = constraintViolations.stream()
                    .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                    .collect(Collectors.joining(", "));

            throw new IllegalArgumentException("Invalid input: " + violationsMessage);
        }
    }

}
