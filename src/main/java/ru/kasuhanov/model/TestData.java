package ru.kasuhanov.model;

import java.io.Serializable;
import java.util.*;


public class TestData implements Serializable {
    private String name;
    private long age;
    private double salary;
    private boolean[] booleen;
    private List<Date> dates = new ArrayList<>();
    private Map<String,String> bigIntegerStringMap = new HashMap<>();
    private Set<Character> chars = new HashSet<>();

    public TestData() {
        chars.add('a');
        chars.add('g');
        chars.add('s');
        chars.add('j');
        chars.add('k');
        chars.add('y');
        chars.add('t');
        chars.add('r');
        chars.add('n');
        chars.add('9');
        age = 523423423;
        name = "werwersigfsdifnkjsdfngkjsdnfgknsdjfgsjdfngnsdfgj";
        salary = 134567890987654323456789123123123123123123123.12312312312312312312312312534237216378123;
        booleen = new boolean[]{true, false, true, false, false};
        bigIntegerStringMap.put("qwe","odin");
        bigIntegerStringMap.put("ssdf","dva");
        bigIntegerStringMap.put("asdfasfa","tri");
        dates.add(new Date());
        dates.add(new Date());
        dates.add(new Date());
        dates.add(new Date());
        dates.add(new Date());
        dates.add(new Date());
        dates.add(new Date());
        dates.add(new Date());
        dates.add(new Date());
        dates.add(new Date());
        dates.add(new Date());
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

    public Map<String, String> getBigIntegerStringMap() {
        return bigIntegerStringMap;
    }

    public void setBigIntegerStringMap(Map<String, String> bigIntegerStringMap) {
        this.bigIntegerStringMap = bigIntegerStringMap;
    }

    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    public Set<Character> getChars() {
        return chars;
    }

    public void setChars(Set<Character> chars) {
        this.chars = chars;
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
