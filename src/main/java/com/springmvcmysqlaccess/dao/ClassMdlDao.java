package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.DBConfig;
import com.springmvcmysqlaccess.config.Res;
import com.springmvcmysqlaccess.models.ClassMdl;

import java.util.List;

public class ClassMdlDao {

    private MySQLAccess db = new MySQLAccess(DBConfig.getDBConfig(), Res.CLASSES_TABLE);


    public Object add(ClassMdl p) {
        return db.add(p);
    }

    public int update(ClassMdl p) {
        return db.update(p);
    }

    public int delete(int id) {
        return db.delete(Res.CLASSES_TABLE_PK + "=" + id);
    }

    public ClassMdl getClassById(int id) {
        return db.getSingleItem(ClassMdl.class, Res.CLASSES_TABLE_PK + "=" + id);
    }

    public List<ClassMdl> getClasses() {
        return db.getFill(
                ClassMdl.class,
                new String[]{"subjectid_fk", "teacherid_fk"},
                new String[]{Res.SUBJECTS_TABLE, Res.TEACHERS_TABLE});
    }
}
