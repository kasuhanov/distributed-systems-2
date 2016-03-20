package ru.kasuhanov;

import ru.kasuhanov.model.TestData;
import ru.kasuhanov.serializer.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application{
    public static void main(String... args)throws Exception{
        long startTime;
        List<ISerializer> serializers = Arrays.asList(new NativeSerialazer(), new XmlSerialazer(),
                new JsonSerialazer(), new MessagePackSerialazer(), new YamlSerialazer());

        for(ISerializer serializer:serializers){
            List<Long> serTime = new ArrayList<>();
            List<Long> deserTime = new ArrayList<>();
            for (int i=0;i<=1000;i++){
                TestData testData = new TestData();
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
        }
    }
}
