package priv.noby.vuespringboot.service;

import priv.noby.vuespringboot.entity.Dep;

import java.util.List;

public interface DepService {
    List<Dep> selectAll();

}
