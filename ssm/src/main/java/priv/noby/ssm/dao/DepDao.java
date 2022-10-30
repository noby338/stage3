package priv.noby.ssm.dao;

import priv.noby.ssm.entity.Dep;

import java.util.List;

public interface DepDao {
    List<Dep> selectAll();
    boolean deleteById();
}
