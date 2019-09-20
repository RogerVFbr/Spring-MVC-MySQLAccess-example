package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.DBConfig;
import com.springmvcmysqlaccess.config.Res;
import com.springmvcmysqlaccess.models.Grade;

import java.util.List;

public class GradeDao {

    private MySQLAccess db = new MySQLAccess(DBConfig.getDBConfig(), Res.GRADES_TABLE);

    public Object add(Grade p) {
        return db.add(p);
    }

    public int update(Grade p) {
        return db.update(p);
    }

    public int delete(int id) {
        return db.delete(Res.GRADES_TABLE_PK + "=" + id);
    }

    public Grade getGradeById(int id) {
        return db.getSingleItem(Grade.class, Res.GRADES_TABLE_PK + "=" + id);
    }

    public List<Grade> getGrades() {
        return db.getFill(Grade.class, "classid_fk", Res.CLASSES_TABLE);
    }
}
