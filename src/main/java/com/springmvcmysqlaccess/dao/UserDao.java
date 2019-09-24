package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.DBConfig;
import com.springmvcmysqlaccess.config.Res;
import com.springmvcmysqlaccess.models.User;

import java.util.List;

public class UserDao {

    private MySQLAccess db = new MySQLAccess(DBConfig.get(), Res.USERS_TABLE);

    public Object add(Object p) {
        return db.add(p);
    }

    public int update(User p) {
        return db.update(p);
    }

    public int delete(int id) {
        return db.delete(Res.USERS_TABLE_PK + "=" + id);
    }

    public User getUserById(int id) {
        return db.getSingleItem(User.class, Res.USERS_TABLE_PK + "=" + id);
    }

    public User getUserByEmail(String email) {
        return db.getSingleItem(User.class, "email='" + email + "'");
    }

    public User getUserByEnrollment(int enrollment) {
        return db.getSingleItem(User.class, "enrollment='" + enrollment + "'");
    }

    public List<User> getUsers() {
        return db.getFill(User.class, "profileid_fk", Res.PROFILES_TABLE);
    }
}
