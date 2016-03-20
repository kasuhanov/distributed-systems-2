package ru.kasuhanov.serializer;

import ru.kasuhanov.model.TestData;

import java.io.*;

public class NativeSerialazer implements ISerializer {
    String filename = "test.native";
    @Override
    public TestData deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream oin = new ObjectInputStream(fis);
        return (TestData)oin.readObject();
    }

    @Override
    public String getName() {
        return "Native Serialazer";
    }

    @Override
    public long getFileLength() {
        return new File(filename).length();
    }

    @Override
    public void serialize(TestData data) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(data);
        oos.flush();
        oos.close();
    }
}
