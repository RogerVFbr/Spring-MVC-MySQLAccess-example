package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.Res;
import com.springmvcmysqlaccess.models.Profile;

import java.util.List;

public class ProfileDao {

    private MySQLAccess db = DBAccess.getAccess();

    public Object add(Profile p) {
        db.setTable(Res.PROFILES_TABLE);
        return db.add(p);
    }

    public int update(Profile p) {
        db.setTable(Res.PROFILES_TABLE);
        return db.update(p);
    }

    public int delete(int id) {
        db.setTable(Res.PROFILES_TABLE);
        return db.delete(Res.PROFILES_TABLE_PK + "=" + id);
    }

    public Profile getProfileById(int id) {
        db.setTable(Res.PROFILES_TABLE);
        return db.getSingleItem(Profile.class, Res.PROFILES_TABLE_PK + "=" + id);
    }

    public List<Profile> getProfiles() {
        db.setTable(Res.PROFILES_TABLE);
        return db.get(Profile.class);
    }
}
