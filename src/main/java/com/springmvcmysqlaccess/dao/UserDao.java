package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.Res;
import com.springmvcmysqlaccess.models.User;

import java.util.List;

public class UserDao {

    private MySQLAccess db = DBAccess.getAccess();

    public Object add(User p) {
        db.setTable(Res.USERS_TABLE);
        return db.add(p);
    }

    public int update(User p) {
        db.setTable(Res.USERS_TABLE);
        return db.update(p);
    }

    public int delete(int id) {
        db.setTable(Res.USERS_TABLE);
        return db.delete(Res.USERS_TABLE_PK + "=" + id);
    }

    public User getUserById(int id) {
        db.setTable(Res.USERS_TABLE);
        return db.getSingleItem(User.class, Res.USERS_TABLE_PK + "=" + id);
    }

    public User getUserByEmail(String email) {
        db.setTable(Res.USERS_TABLE);
        return db.getSingleItem(User.class, "email='" + email + "'");
    }

    public List<User> getUsers() {
        db.setTable(Res.USERS_TABLE);
        return db.get(User.class);
    }
}
