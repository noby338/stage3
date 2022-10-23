package priv.noby.springboot2.dao;


import priv.noby.springboot2.entity.Account;

public interface AccountDao {
    Account selectByName(String name);
    boolean update(Account account);
}
