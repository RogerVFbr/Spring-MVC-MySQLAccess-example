package com.springmvcmysqlaccess.dao;

import com.springmvcmysqlaccess.models.User;
import com.springmvcmysqlaccess.config.DBConfig;
import com.mysqlaccess.MySQLAccess;

import java.util.List;

public class UserDao {

    private MySQLAccess table = new MySQLAccess(DBConfig.AWS_JAVAEE, "user");
    private String primaryKeyColumnName = "userid";

    public Object add(User p) {
        return table.add(p);
    }

    public int update(User p) {
        return table.update(p);
    }

    public int delete(int id) {
        return table.delete(primaryKeyColumnName + "=" + id);
    }

    public User getUserById(int id) {
        return table.getSingleItem(User.class, primaryKeyColumnName + "=" + id);
    }

    public User getUserByEmail(String email) {
        return table.getSingleItem(User.class, "email='" + email + "'");
    }

    public List<User> getUsers() {
        return table.get(User.class);
    }
}
