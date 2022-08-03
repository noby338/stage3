package priv.noby.vuespringboot.dao;


import priv.noby.vuespringboot.entity.Dep;

import java.util.List;

public interface DepDao {
    List<Dep> selectAll();
    boolean deleteByDid();
    Dep selectByDname(String dname);
}
