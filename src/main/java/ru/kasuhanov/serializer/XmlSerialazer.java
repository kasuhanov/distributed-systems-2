package ru.kasuhanov.serializer;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.kasuhanov.model.TestData;

import java.io.File;
import java.io.IOException;

public class XmlSerialazer implements ISerializer {
    private String filename = "test.xml";
    @Override
    public TestData deserialize() throws IOException, ClassNotFoundException {
        XmlMapper mapper = new XmlMapper();
        return mapper.readValue(new File(filename), TestData.class);
    }

    @Override
    public String getName() {
        return "XML Serializer";
    }

    @Override
    public long getFileLength() {
        return new File(filename).length();
    }

    @Override
    public void serialize(TestData data) throws IOException {
        XmlMapper mapper = new XmlMapper();
        mapper.writeValue(new File(filename), data);
    }
}
