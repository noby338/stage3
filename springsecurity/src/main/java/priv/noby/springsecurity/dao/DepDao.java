package priv.noby.springsecurity.dao;


import priv.noby.springsecurity.entity.Dep;

import java.util.List;

public interface DepDao {
    List<Dep> selectAll();
    boolean deleteByDid();
    Dep selectByDname(String dname);
}
