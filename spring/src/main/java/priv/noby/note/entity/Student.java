package priv.noby.note.entity;


import lombok.Data;

import java.util.Objects;

@Data
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private School school;

    public void init() {
        System.out.println("Student.init");
    }

    public void destroy() {
        System.out.println("Student.destroy");
    }

    public Student() {
        System.out.println("Student.Student 无参构造");
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Student.Student 有参构造");
    }

    public void setAge(int age) {
        this.age = age;
        System.out.println("Student.setAge");
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(school, student.school);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, school);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
