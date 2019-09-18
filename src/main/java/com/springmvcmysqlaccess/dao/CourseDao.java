package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.Res;
import com.springmvcmysqlaccess.models.Course;

import java.util.List;

public class CourseDao {

    private MySQLAccess db = DBAccess.getAccess();

    public Object add(Course p) {
        db.setTable(Res.COURSES_TABLE);
        return db.add(p);
    }

    public int update(Course p) {
        db.setTable(Res.COURSES_TABLE);
        return db.update(p);
    }

    public int delete(int id) {
        db.setTable(Res.COURSES_TABLE);
        return db.delete(Res.COURSES_TABLE_PK + "=" + id);
    }

    public Course getClassById(int id) {
        db.setTable(Res.COURSES_TABLE);
        return db.getSingleItem(Course.class, Res.COURSES_TABLE_PK + "=" + id);
    }

    public List<Course> getCourses() {
        db.setTable(Res.COURSES_TABLE);
        return db.get(Course.class);
    }
}
