package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.DBConfig;
import com.springmvcmysqlaccess.models.Course;

import java.util.List;

public class CourseDao {

    private MySQLAccess table = new MySQLAccess(DBConfig.AWS_JAVAEE, "course");
    private String primaryKeyColumnName = "courseid";

    public Object add(Course p) {
        return table.add(p);
    }

    public int update(Course p) {
        return table.update(p);
    }

    public int delete(int id) {
        return table.delete(primaryKeyColumnName + "=" + id);
    }

    public Course getClassById(int id) {
        return table.getSingleItem(Course.class,
                primaryKeyColumnName + "=" + id);
    }

    public List<Course> getCourses() {
        return table.get(Course.class);
    }
}
