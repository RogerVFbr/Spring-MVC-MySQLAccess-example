package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.DBConfig;
import com.springmvcmysqlaccess.models.Student;

import java.util.List;

public class StudentDao {
    private MySQLAccess table = new MySQLAccess(DBConfig.AWS_JAVAEE, "student");
    private String primaryKeyColumnName = "studentid";

    public Object add(Student p) {
        return table.add(p);
    }

    public int update(Student p) {
        return table.update(p);
    }

    public int delete(int id) {
        return table.delete(primaryKeyColumnName + "=" + id);
    }

    public Student getStudentById(int id) {
        return table.getSingleItem(Student.class,
                primaryKeyColumnName + "=" + id);
    }

    public List<Student> getStudents() {
        return table.get(Student.class);
    }
}
