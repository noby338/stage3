package priv.noby.mavenssm.service.impl;

import org.springframework.stereotype.Service;
import priv.noby.mavenssm.service.DepService;
import priv.noby.note.dao.DepDao;
import priv.noby.note.entity.Dep;

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
