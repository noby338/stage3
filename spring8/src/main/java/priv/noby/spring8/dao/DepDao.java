package priv.noby.spring8.dao;

import priv.noby.spring8.entity.Dep;

import java.util.List;

public interface DepDao {
    List<Dep> selectAll();
    boolean deleteByDid();
}
