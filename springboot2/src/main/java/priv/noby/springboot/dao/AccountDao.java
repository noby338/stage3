package priv.noby.springboot.dao;


import priv.noby.springboot.entity.Account;

public interface AccountDao {
    public Account selectByName(String name);
    public boolean update(Account account);
}
