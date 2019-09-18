package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.Res;
import com.springmvcmysqlaccess.models.Student;

import java.util.List;

public class StudentDao {

    private MySQLAccess db = DBAccess.getAccess();

    public Object add(Student p) {
        db.setTable(Res.STUDENTS_TABLE);
        return db.add(p);
    }

    public int update(Student p) {
        db.setTable(Res.STUDENTS_TABLE);
        return db.update(p);
    }

    public int delete(int id) {
        db.setTable(Res.STUDENTS_TABLE);
        return db.delete(Res.STUDENTS_TABLE_PK + "=" + id);
    }

    public Student getStudentById(int id) {
        db.setTable(Res.STUDENTS_TABLE);
        return db.getSingleItem(Student.class, Res.STUDENTS_TABLE_PK + "=" + id);
    }

    public List<Student> getStudents() {
        db.setTable(Res.STUDENTS_TABLE);
        return db.get(Student.class);
    }
}
