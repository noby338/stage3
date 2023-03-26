package priv.noby.mavenssm.service;

import priv.noby.mavenssm.entity.Dep;

import java.util.List;

public interface DepService {
    List<Dep> findAll();
    boolean removeBydid(int did);
}
