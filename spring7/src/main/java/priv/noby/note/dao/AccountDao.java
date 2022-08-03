package priv.noby.note.dao;

import priv.noby.note.entity.Account;

public interface AccountDao {
    public Account selectByName(String name);
    public boolean update(Account account);
}
