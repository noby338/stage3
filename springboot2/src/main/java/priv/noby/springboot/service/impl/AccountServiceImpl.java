package priv.noby.springboot.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import priv.noby.springboot.dao.AccountDao;
import priv.noby.springboot.entity.Account;
import priv.noby.springboot.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDao accountDao = null;

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
                if (false) {
                    throw new RuntimeException("事务异常");
                }
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
