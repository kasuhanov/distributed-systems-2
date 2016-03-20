package ru.kasuhanov;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;
import ru.kasuhanov.model.TestData;
import ru.kasuhanov.serializer.*;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application{
    public static void main(String... args)throws Exception{
        long startTime;
        TestData testData = new TestData();
        testData.setAge(523423423);
        testData.setName("werwersigfsdifnkjsdfngkjsdnfgknsdjfgsjdfngnsdfgj");
        testData.setSalary(134567890987654323456789123123123123123123123.12312312312312312312312312534237216378123);
        testData.setBooleen(new boolean[]{true, false, true, false, false});
        testData.getBigIntegerStringMap().put("qwe","odin");
        testData.getBigIntegerStringMap().put("ssdf","dva");
        testData.getBigIntegerStringMap().put("asdfasfa","tri");

        List<ISerializer> serializers = Arrays.asList(new NativeSerialazer(), new XmlSerialazer(), new JacksonXmlSerialazer(),
                new YamlSerialazer(), new JsonSerialazer(), new MessagePackSerialazer());

        for(ISerializer serializer:serializers){
            List<Long> serTime = new ArrayList<>();
            List<Long> deserTime = new ArrayList<>();
            for (int i=0;i<=1000;i++){
                startTime = System.currentTimeMillis();
                serializer.serialize(testData);
                serTime.add(System.currentTimeMillis()-startTime);
                startTime = System.currentTimeMillis();
                serializer.deserialize();
                deserTime.add(System.currentTimeMillis()-startTime);
            }
            System.out.println(serializer.getName());
            System.out.println("serialization average value: "+serTime.stream().mapToLong(t->t).average());
            System.out.println("deserialization average value: "+deserTime.stream().mapToLong(t->t).average());
            System.out.println("size: "+serializer.getFileLength());
        };
    }
}
