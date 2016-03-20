package ru.kasuhanov.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.msgpack.jackson.dataformat.MessagePackFactory;
import ru.kasuhanov.model.TestData;

import java.io.File;
import java.io.IOException;

public class MessagePackSerialazer implements ISerializer {
    private String filename = "test.mp";
    @Override
    public TestData deserialize() throws IOException, ClassNotFoundException {
        ObjectMapper mapper = new ObjectMapper(new MessagePackFactory());
        return mapper.readValue(new File(filename), TestData.class);
    }

    @Override
    public String getName() {
        return "MessagePack Serializer";
    }

    @Override
    public long getFileLength() {
        return new File(filename).length();
    }

    @Override
    public void serialize(TestData data) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new MessagePackFactory());
        mapper.writeValue(new File(filename), data);
    }
}
