package priv.noby.mybatisgenerator.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import priv.noby.mybatisgenerator.dao.AccountDao;
import priv.noby.mybatisgenerator.entity.Account;
import priv.noby.mybatisgenerator.service.AccountService;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    AccountDao accountDao;

    //织入事务管理
    @Transactional//设置回滚的异常（默认为runtimeException）
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
                //模拟事务异常
                int i = 1/0;
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
