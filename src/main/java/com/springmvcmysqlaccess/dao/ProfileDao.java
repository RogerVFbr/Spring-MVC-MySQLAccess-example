package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.DBConfig;
import com.springmvcmysqlaccess.models.Profile;

import java.util.List;

public class ProfileDao {
    private MySQLAccess table = new MySQLAccess(DBConfig.AWS_JAVAEE, "profile");
    private String primaryKeyColumnName = "profileid";

    public Object add(Profile p) {
        return table.add(p);
    }

    public int update(Profile p) {
        return table.update(p);
    }

    public int delete(int id) {
        return table.delete(primaryKeyColumnName + "=" + id);
    }

    public Profile getProfileById(int id) {
        return table.getSingleItem(Profile.class,
                primaryKeyColumnName + "=" + id);
    }

    public List<Profile> getProfiles() {
        return table.get(Profile.class);
    }
}
