package priv.noby.ssm.service.impl;

import priv.noby.ssm.dao.DepDao;
import priv.noby.ssm.entity.Dep;
import priv.noby.ssm.service.DepService;

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
