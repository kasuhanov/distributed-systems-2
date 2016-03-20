package ru.kasuhanov.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class TestData implements Serializable {
    public String name;
    public long age;
    public double salary;
    public boolean[] booleen;
    public Map<Character,String> bigIntegerStringMap = new HashMap<>();

    public TestData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean[] getBooleen() {
        return booleen;
    }

    public void setBooleen(boolean[] booleen) {
        this.booleen = booleen;
    }

    public Map<Character, String> getBigIntegerStringMap() {
        return bigIntegerStringMap;
    }

    public void setBigIntegerStringMap(Map<Character, String> bigIntegerStringMap) {
        this.bigIntegerStringMap = bigIntegerStringMap;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", booleen=" + Arrays.toString(booleen) +
                ", bigIntegerStringMap=" + bigIntegerStringMap +
                '}';
    }
}
