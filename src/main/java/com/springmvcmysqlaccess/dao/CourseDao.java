package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.DBConfig;
import com.springmvcmysqlaccess.config.Res;
import com.springmvcmysqlaccess.models.Course;

import java.util.List;

public class CourseDao {

    private MySQLAccess db = new MySQLAccess(DBConfig.getDBConfig(), Res.COURSES_TABLE);

    public Object add(Course p) {
        return db.add(p);
    }

    public int update(Course p) {
        return db.update(p);
    }

    public int delete(int id) {
        return db.delete(Res.COURSES_TABLE_PK + "=" + id);
    }

    public Course getCourseById(int id) {
        return db.getSingleItem(Course.class, Res.COURSES_TABLE_PK + "=" + id);
    }

    public List<Course> getCourses() {
        return db.get(Course.class);
    }
}
