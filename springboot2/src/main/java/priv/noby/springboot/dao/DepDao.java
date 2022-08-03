package priv.noby.springboot.dao;


import priv.noby.springboot.entity.Dep;

import java.util.List;

public interface DepDao {
    List<Dep> selectAll();
    boolean deleteByDid();
}
