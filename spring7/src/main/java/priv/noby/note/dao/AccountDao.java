package priv.noby.note.dao;

import priv.noby.note.entity.Account;

public interface AccountDao {
    Account selectByName(String name);
    boolean update(Account account);
}
