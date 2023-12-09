package serialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class XmlEntitySerialization<T> implements EntitySerialization<T> {
    private final XmlMapper xmlMapper;

    public XmlEntitySerialization() {
        xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public void serialize(List<T> entities, String filePath) throws IOException {
        xmlMapper.writeValue(new File(filePath), entities);
    }

    @Override
    public List<T> deserialize(String filePath) throws IOException {
        return xmlMapper.readValue(new File(filePath), new TypeReference<List<T>>() {});
    }
}
