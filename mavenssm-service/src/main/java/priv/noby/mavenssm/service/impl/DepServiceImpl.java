package priv.noby.mavenssm.service.impl;

import org.springframework.stereotype.Service;
import priv.noby.mavenssm.dao.DepDao;
import priv.noby.mavenssm.entity.Dep;
import priv.noby.mavenssm.service.DepService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepServiceImpl implements DepService {
    @Resource
    DepDao depDao;

    @Override
    public List<Dep> findAll() {
        return depDao.selectAll();
    }

    @Override
    public boolean removeBydid(int did) {
        return false;
    }
}
