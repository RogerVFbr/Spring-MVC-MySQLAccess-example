package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.Res;
import com.springmvcmysqlaccess.models.Grade;

import java.util.List;

public class GradeDao {

    private MySQLAccess db = DBAccess.getAccess();

    public Object add(Grade p) {
        db.setTable(Res.GRADES_TABLE);
        return db.add(p);
    }

    public int update(Grade p) {
        db.setTable(Res.GRADES_TABLE);
        return db.update(p);
    }

    public int delete(int id) {
        db.setTable(Res.GRADES_TABLE);
        return db.delete(Res.GRADES_TABLE_PK + "=" + id);
    }

    public Grade getGradeById(int id) {
        db.setTable(Res.GRADES_TABLE);
        return db.getSingleItem(Grade.class, Res.GRADES_TABLE_PK + "=" + id);
    }

    public List<Grade> getGrades() {
        db.setTable(Res.GRADES_TABLE);
        return db.get(Grade.class);
    }
}
