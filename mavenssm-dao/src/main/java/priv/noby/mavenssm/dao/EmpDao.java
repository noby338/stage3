package priv.noby.mavenssm.dao;

import priv.noby.note.entity.Emp;

import java.util.List;

public interface EmpDao {
    List<Emp> selectAll();
}
