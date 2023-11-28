package methodRefernce;

import java.util.List;

public class Student {
    private String name;
    private int age;
    private String sex;
    private int soccer;

    public Student(){

    }
    public Student(String name,int age){
        this.name = name;
        this.age =age;
    }
    public Student(String name, int age, String sex, int soccer) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.soccer = soccer;
    }

    public String getName() {
        return name;
    }
    public static int compareByAge(Student a, Student b) {
        return a.getAge() - b.getAge();
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getSoccer() {
        return soccer;
    }

    public void setSoccer(int soccer) {
        this.soccer = soccer;
    }
}
