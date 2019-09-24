package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.DBConfig;
import com.springmvcmysqlaccess.config.Res;
import com.springmvcmysqlaccess.models.Student;

import java.util.List;

public class StudentDao {

    private MySQLAccess db = new MySQLAccess(DBConfig.getDBConfig(), Res.STUDENTS_TABLE);

    public Object add(Student p) {
        return db.add(p);
    }

    public int update(Student p) {
        return db.update(p);
    }

    public int delete(int id) {
        return db.delete(Res.STUDENTS_TABLE_PK + "=" + id);
    }

    public Student getStudentById(int id) {
        return db.getSingleItem(Student.class, Res.STUDENTS_TABLE_PK + "=" + id);
    }

    public Student getStudentByUserId(int id) {
        return db.getSingleItem(Student.class, "userid_fk=" + id);
    }

    public List<Student> getStudents() {
        return db.getFill(
                Student.class,
                new String[]{"userid_fk", "courseid_fk"},
                new String[]{Res.USERS_TABLE, Res.COURSES_TABLE});
    }
}
