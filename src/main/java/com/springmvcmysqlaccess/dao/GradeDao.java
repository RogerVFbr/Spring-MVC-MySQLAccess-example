package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.DBConfig;
import com.springmvcmysqlaccess.models.Grade;

import java.util.List;

public class GradeDao {

    private MySQLAccess table = new MySQLAccess(DBConfig.AWS_JAVAEE, "grade");
    private String primaryKeyColumnName = "gradeid";

    public Object add(Grade p) {
        return table.add(p);
    }

    public int update(Grade p) {
        return table.update(p);
    }

    public int delete(int id) {
        return table.delete(primaryKeyColumnName + "=" + id);
    }

    public Grade getGradeById(int id) {
        return table.getSingleItem(Grade.class,
                primaryKeyColumnName + "=" + id);
    }

    public List<Grade> getGrades() {
        return table.get(Grade.class);
    }
}
