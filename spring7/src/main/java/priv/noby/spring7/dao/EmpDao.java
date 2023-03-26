package priv.noby.spring7.dao;

import priv.noby.spring7.entity.Emp;

import java.util.List;

public interface EmpDao {
    List<Emp> selectAll();
}
