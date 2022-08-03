package priv.noby.note.dao;

import priv.noby.note.entity.Dep;

import java.util.List;

public interface DepDao {
    List<Dep> selectAll();
    boolean deleteByDid();
}
