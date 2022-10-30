package priv.noby.spring8.dao;

import priv.noby.spring8.entity.Emp;

import java.util.List;

public interface EmpDao {
    List<Emp> selectAll();
}
