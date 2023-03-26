package priv.noby.mavenssm.dao;

import priv.noby.mavenssm.entity.Emp;

import java.util.List;

public interface EmpDao {
    List<Emp> selectAll();
}
