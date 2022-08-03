package priv.noby.vuespringboot.dao;


import priv.noby.vuespringboot.entity.Emp;

import java.util.List;

//自动创建这个接口的实现类
public interface EmpDao {
    List<Emp> selectAll();
    List<Emp> selectByEmp(Emp emp);
    boolean deleteByEid(int eid);
    boolean updateByEmp(Emp emp);
    boolean insert(Emp emp);
}
