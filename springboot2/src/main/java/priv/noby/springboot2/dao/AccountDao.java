package priv.noby.springboot2.dao;


import priv.noby.springboot2.entity.Account;

//mybatis的注解，表示该接口类的实现类对象交给mybatis底层创建，然后交由Spring框架管理；使用该注解后可省略驱动类中的@MapperScan()注解的书写
//@Mapper
public interface AccountDao {
    Account selectByName(String name);
    boolean update(Account account);
}
