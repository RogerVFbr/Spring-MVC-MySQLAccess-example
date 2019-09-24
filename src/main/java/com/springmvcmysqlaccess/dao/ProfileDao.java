package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.DBConfig;
import com.springmvcmysqlaccess.config.Res;
import com.springmvcmysqlaccess.models.Profile;

import java.util.List;

public class ProfileDao {

    private MySQLAccess db = new MySQLAccess(DBConfig.get(), Res.PROFILES_TABLE);

    public Object add(Profile p) {
        return db.add(p);
    }

    public int update(Profile p) {
        return db.update(p);
    }

    public int delete(int id) {
        return db.delete(Res.PROFILES_TABLE_PK + "=" + id);
    }

    public Profile getProfileById(int id) {
        return db.getSingleItem(Profile.class, Res.PROFILES_TABLE_PK + "=" + id);
    }

    public List<Profile> getProfiles() {
        return db.get(Profile.class);
    }
}
