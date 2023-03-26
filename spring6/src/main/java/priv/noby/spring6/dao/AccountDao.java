package priv.noby.spring6.dao;

import priv.noby.spring6.entity.Account;

public interface AccountDao {
    Account selectByName(String name);
    boolean update(Account account);
}
