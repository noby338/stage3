package priv.noby.vuespringboot.service;

import priv.noby.vuespringboot.entity.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> selectAll(int pageNum);
    List<Emp> selectByEmp(int pageNum,Emp emp);
    boolean deleteByEid(int eid);
    boolean updateByEmp(Emp emp);
    boolean insert(Emp emp);

}
