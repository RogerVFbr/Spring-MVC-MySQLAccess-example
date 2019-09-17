package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.DBConfig;
import com.springmvcmysqlaccess.models.Subject;
import com.springmvcmysqlaccess.models.Teacher;

import java.util.List;

public class TeacherDao {

    private MySQLAccess table = new MySQLAccess(DBConfig.AWS_JAVAEE, "teacher");
    private String primaryKeyColumnName = "teacherid";

    public Object add(Teacher p) {
        return table.add(p);
    }

    public int update(Teacher p) {
        return table.update(p);
    }

    public int delete(int id) {
        return table.delete(primaryKeyColumnName + "=" + id);
    }

    public Teacher getTeacherById(int id) {
        return table.getSingleItem(Teacher.class,
                primaryKeyColumnName + "=" + id);
    }

    public List<Teacher> getTeachers() {
        return table.get(Teacher.class);
    }
}
