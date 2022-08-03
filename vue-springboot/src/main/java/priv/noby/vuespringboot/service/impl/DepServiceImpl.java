package priv.noby.vuespringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.noby.vuespringboot.dao.DepDao;
import priv.noby.vuespringboot.entity.Dep;
import priv.noby.vuespringboot.service.DepService;

import java.util.List;

@Service
public class DepServiceImpl implements DepService {
    @Autowired
    DepDao depDao;

    @Override
    public List<Dep> selectAll() {
        List<Dep> deps = depDao.selectAll();
        return deps;
    }
}
