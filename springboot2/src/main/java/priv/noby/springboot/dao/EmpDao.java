package priv.noby.springboot.dao;


import priv.noby.springboot.entity.Emp;

import java.util.List;
//自动创建这个接口的实现类
public interface EmpDao {
    List<Emp> selectAll();
}
