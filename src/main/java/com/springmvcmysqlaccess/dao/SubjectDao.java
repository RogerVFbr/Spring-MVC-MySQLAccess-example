package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.DBConfig;
import com.springmvcmysqlaccess.models.Subject;

import java.util.List;

public class SubjectDao {

    private MySQLAccess table = new MySQLAccess(DBConfig.AWS_JAVAEE, "subject");
    private String primaryKeyColumnName = "subjectid";

    public Object add(Subject p) {
        return table.add(p);
    }

    public int update(Subject p) {
        return table.update(p);
    }

    public int delete(int id) {
        return table.delete(primaryKeyColumnName + "=" + id);
    }

    public Subject getSubjectById(int id) {
        return table.getSingleItem(Subject.class,
                primaryKeyColumnName + "=" + id);
    }

    public List<Subject> getSubjects() {
        return table.get(Subject.class);
    }
}
