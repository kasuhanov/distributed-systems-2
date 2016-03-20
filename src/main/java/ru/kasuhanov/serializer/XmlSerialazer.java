package ru.kasuhanov.serializer;

import ru.kasuhanov.model.TestData;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class XmlSerialazer implements ISerializer {
    private String filename = "test.xml";
    @Override
    public TestData deserialize() throws IOException, ClassNotFoundException {
        XMLDecoder decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)));
        return (TestData)decoder.readObject();
    }

    @Override
    public long getFileLength() {
        return new File(filename).length();
    }

    @Override
    public String getName() {
        return "Xml Serializer";
    }

    @Override
    public void serialize(TestData data) throws IOException {
        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)));
        encoder.writeObject(data);
        encoder.close();
    }
}
