package priv.noby.spring8.service;

import priv.noby.spring8.entity.Dep;

import java.util.List;

public interface DepService {
    List<Dep> selectAll();
    boolean deleteById(int id);
}
