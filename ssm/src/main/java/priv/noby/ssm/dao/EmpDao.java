package priv.noby.ssm.dao;

import priv.noby.ssm.entity.Emp;

import java.util.List;

public interface EmpDao {
    List<Emp> selectAll();
}
