package priv.noby.springsecurity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.noby.springsecurity.dao.DepDao;
import priv.noby.springsecurity.entity.Dep;
import priv.noby.springsecurity.service.DepService;

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
