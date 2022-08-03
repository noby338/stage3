package priv.noby.note.service.impl;

import priv.noby.note.dao.DepDao;
import priv.noby.note.entity.Dep;
import priv.noby.note.service.DepService;

import java.util.List;

public class DepServiceImpl implements DepService {
    DepDao depDao;

    public void setDepDao(DepDao depDao) {
        this.depDao = depDao;
    }

    @Override
    public List<Dep> findAll() {
        return depDao.selectAll();
    }

    @Override
    public boolean removeBydid(int did) {

        return false;
    }
}
