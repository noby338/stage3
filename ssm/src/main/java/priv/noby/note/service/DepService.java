package priv.noby.note.service;

import priv.noby.note.entity.Dep;

import java.util.List;

public interface DepService {
    List<Dep> findAll();
    boolean removeBydid(int did);
}
