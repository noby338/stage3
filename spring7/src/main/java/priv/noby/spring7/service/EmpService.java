package priv.noby.spring7.service;

import priv.noby.spring7.entity.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> selectAll();
}
