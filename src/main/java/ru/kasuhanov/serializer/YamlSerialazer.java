package ru.kasuhanov.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import ru.kasuhanov.model.TestData;

import java.io.File;
import java.io.IOException;

public class YamlSerialazer implements ISerializer {
    private String filename =  "test.yaml";
    @Override
    public TestData deserialize()  throws IOException, ClassNotFoundException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(new File(filename), TestData.class);
    }

    @Override
    public long getFileLength() {
        return new File(filename).length();
    }

    @Override
    public String getName() {
        return "Yaml Serialazer";
    }

    @Override
    public void serialize(TestData data) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.writeValue(new File(filename), data);
    }
}
