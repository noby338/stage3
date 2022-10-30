package priv.noby.spring8.service.impl;

import priv.noby.spring8.dao.DepDao;
import priv.noby.spring8.entity.Dep;
import priv.noby.spring8.service.DepService;

import java.util.List;

public class DepServiceImpl implements DepService {
    DepDao depDao;

    public void setDepDao(DepDao depDao) {
        this.depDao = depDao;
    }

    @Override
    public List<Dep> selectAll() {
        return depDao.selectAll();
    }

    @Override
    public boolean deleteById(int did) {
        return false;
    }
}
