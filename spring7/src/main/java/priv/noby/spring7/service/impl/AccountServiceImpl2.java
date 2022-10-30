package priv.noby.spring7.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import priv.noby.spring7.dao.AccountDao;
import priv.noby.spring7.entity.Account;
import priv.noby.spring7.service.AccountService;

/**
 * 通过注解配置事务
 */
@Service("accountServiceImpl2")
public class AccountServiceImpl2 implements AccountService {
    @Autowired
    AccountDao accountDao;

//        @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = false)//织入事务管理
    @Transactional(rollbackFor = Exception.class)//设置回滚的异常（默认为runtimeException）
    @Override
    public void transfer(String send, String receive, int money) {
        Account sendAcc = accountDao.selectByName(send);
        Account receiveAcc = accountDao.selectByName(receive);
        if (sendAcc != null && receiveAcc != null) {
            if (money <= 0) {
                System.out.println("金额无效");
            } else if (sendAcc.getMoney() >= money) {
                sendAcc.setMoney(sendAcc.getMoney() - money);
                accountDao.update(sendAcc);
                //模拟事务出现异常，查看是否回滚
                int i = 1 / 0;
                receiveAcc.setMoney(receiveAcc.getMoney() + money);
                accountDao.update(receiveAcc);
                System.out.println("转账成功");
            } else {
                System.out.println("余额不足");
            }
        } else {
            System.out.println("账号不存在");
        }
    }
}
