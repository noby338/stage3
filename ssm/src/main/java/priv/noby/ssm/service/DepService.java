package priv.noby.ssm.service;

import priv.noby.ssm.entity.Dep;

import java.util.List;

public interface DepService {
    List<Dep> findAll();
    boolean removeBydid(int did);
}
