package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.DBConfig;
import com.springmvcmysqlaccess.config.Res;
import com.springmvcmysqlaccess.models.Subject;

import java.util.List;

public class SubjectDao {

    private MySQLAccess db = new MySQLAccess(DBConfig.get(), Res.SUBJECTS_TABLE);

    public Object add(Subject p) {
        return db.add(p);
    }

    public int update(Subject p) {
        return db.update(p);
    }

    public int delete(int id) {
        return db.delete(Res.SUBJECTS_TABLE_PK + "=" + id);
    }

    public Subject getSubjectById(int id) {
        return db.getSingleItem(Subject.class, Res.SUBJECTS_TABLE_PK + "=" + id);
    }

    public List<Subject> getSubjects() {
        return db.get(Subject.class);
    }
}
