package priv.noby.spring8.service;

import priv.noby.spring8.entity.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> selectAll();
}
