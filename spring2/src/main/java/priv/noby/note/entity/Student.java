package priv.noby.note.entity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component //配置该类可通过 Spring 框架实例化  以下注解等同：@Repository（给Dao类使用） @Service @controller
@Scope("singleton")//配置作用范围（单例模式、原型模式） singleton 为单例
public class Student {
    @Value("noby") //给基本数据类型赋值
    private String name;
    @Value("20")
    private int age;
    @Autowired //通过属性类型自动注入注解（给引用数据类型赋值）
//    @Qualifier("school")//加上该注解表示通过属性名自动注入

//    @Resource//jdk1.6之后出的注解，等同于 @Autowired 注解
//    @Resource(name = "school")//等同于 @Autowired 加 @Qualifier("school")注解
    private School school;
    @PostConstruct //初始化方法注解
    public void init() {
        System.out.println("Student.init");
    }
    @PreDestroy //销毁方法注解
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
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
