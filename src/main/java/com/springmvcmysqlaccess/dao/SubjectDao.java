package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.Res;
import com.springmvcmysqlaccess.models.Subject;

import java.util.List;

public class SubjectDao {

    private MySQLAccess db = DBAccess.getAccess();
    private String primaryKeyColumnName = "subjectid";

    public Object add(Subject p) {
        db.setTable(Res.SUBJECTS_TABLE);
        return db.add(p);
    }

    public int update(Subject p) {
        db.setTable(Res.SUBJECTS_TABLE);
        return db.update(p);
    }

    public int delete(int id) {
        db.setTable(Res.SUBJECTS_TABLE);
        return db.delete(Res.SUBJECTS_TABLE_PK + "=" + id);
    }

    public Subject getSubjectById(int id) {
        db.setTable(Res.SUBJECTS_TABLE);
        return db.getSingleItem(Subject.class, Res.SUBJECTS_TABLE_PK + "=" + id);
    }

    public List<Subject> getSubjects() {
        db.setTable(Res.SUBJECTS_TABLE);
        return db.get(Subject.class);
    }
}
