package serialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonEntitySerialization<T> implements EntitySerialization<T> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public JsonEntitySerialization() {
        // Додаємо модуль для підтримки типів дати та часу з Java 8
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public void serialize(List<T> entities, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), entities);
    }

    @Override
    public List<T> deserialize(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), new TypeReference<List<T>>() {});
    }
}


