package ru.kasuhanov.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.kasuhanov.model.TestData;

import java.io.File;
import java.io.IOException;

public class JsonSerialazer implements ISerializer {
    private String filename = "test.json";
    @Override
    public TestData deserialize() throws IOException, ClassNotFoundException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filename), TestData.class);
    }

    @Override
    public String getName() {
        return "Json Serializer";
    }

    @Override
    public long getFileLength() {
        return new File(filename).length();
    }

    @Override
    public void serialize(TestData data) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(filename), data);
    }
}
