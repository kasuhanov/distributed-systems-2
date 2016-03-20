package ru.kasuhanov.serializer;

import ru.kasuhanov.model.TestData;

import java.io.IOException;

public interface ISerializer {
    public void serialize(TestData data) throws IOException;
    public TestData deserialize() throws IOException, ClassNotFoundException;
    public String getName();
    public long getFileLength();
}
