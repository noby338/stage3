package priv.noby.note.entity;


import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private School school;

    public void init() {
        System.out.println("Student.init");
    }

    public void destroy() {
        System.out.println("Student.destroy");
    }

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
        System.out.println("调用了 setAge() 方法");
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
