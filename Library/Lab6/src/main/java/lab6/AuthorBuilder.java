package lab6;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class AuthorBuilder {
    //private static final String DATE_PATTERN = "\\d{4}-\\d{2}-\\d{2}";

    @NotNull
    @NotBlank
    private String name;
    @Past(message = "Birth date must be in the past")
    private LocalDate birthDate;

    public AuthorBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public AuthorBuilder setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }
    public Author build() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<AuthorBuilder>> constraintViolations = validator.validate(this);

        if (constraintViolations.isEmpty()) {
            return new Author(name, birthDate);
        } else {
            String violationsMessage = constraintViolations.stream()
                    .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                    .collect(Collectors.joining(", "));

            throw new IllegalArgumentException("Invalid input: " + violationsMessage);
        }
    }
}
