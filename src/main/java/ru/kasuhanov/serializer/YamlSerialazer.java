package ru.kasuhanov.serializer;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;
import ru.kasuhanov.model.TestData;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class YamlSerialazer implements ISerializer {
    private String filename =  "test.yaml";
    @Override
    public TestData deserialize()  throws IOException, ClassNotFoundException {
        YamlReader reader = new YamlReader(new FileReader(filename));
        return (TestData)reader.read();
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
        YamlWriter writer = new YamlWriter(new FileWriter(filename));
        writer.write(data);
        writer.close();
    }
}
