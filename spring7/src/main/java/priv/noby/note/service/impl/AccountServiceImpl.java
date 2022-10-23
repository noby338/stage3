package priv.noby.note.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.noby.note.dao.AccountDao;
import priv.noby.note.entity.Account;
import priv.noby.note.service.AccountService;

/**
 * 通过配置文件配置事务
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDao accountDao;

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
