package priv.noby.spring7.dao;

import priv.noby.spring7.entity.Account;

public interface AccountDao {
    Account selectByName(String name);
    boolean update(Account account);
}
