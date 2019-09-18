package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.Res;
import com.springmvcmysqlaccess.models.ClassMdl;

import java.util.List;

public class ClassMdlDao {

    private MySQLAccess db = DBAccess.getAccess();

    public Object add(ClassMdl p) {
        db.setTable(Res.CLASSES_TABLE);
        return db.add(p);
    }

    public int update(ClassMdl p) {
        db.setTable(Res.CLASSES_TABLE);
        return db.update(p);
    }

    public int delete(int id) {
        db.setTable(Res.CLASSES_TABLE);
        return db.delete(Res.CLASSES_TABLE_PK + "=" + id);
    }

    public ClassMdl getClassById(int id) {
        db.setTable(Res.CLASSES_TABLE);
        return db.getSingleItem(ClassMdl.class, Res.CLASSES_TABLE_PK + "=" + id);
    }

    public List<ClassMdl> getClasses() {
        db.setTable(Res.CLASSES_TABLE);
        return db.get(ClassMdl.class);
    }
}
