package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.DBConfig;
import com.springmvcmysqlaccess.config.Res;
import com.springmvcmysqlaccess.models.Teacher;

import java.util.List;

public class TeacherDao {

    private MySQLAccess db = new MySQLAccess(DBConfig.getDBConfig(), Res.TEACHERS_TABLE);

    public Object add(Teacher p) {
        return db.add(p);
    }

    public int update(Teacher p) {
        return db.update(p);
    }

    public int delete(int id) {
        return db.delete(Res.TEACHERS_TABLE_PK + "=" + id);
    }

    public Teacher getTeacherById(int id) {
        return db.getSingleItem(Teacher.class, Res.TEACHERS_TABLE_PK + "=" + id);
    }

    public Teacher getTeacherByUserId(int id) {
        return db.getSingleItem(Teacher.class, "userid_fk=" + id);
    }

    public List<Teacher> getTeachers() {
        return db.getFill(Teacher.class, "userid_fk", Res.USERS_TABLE);
    }
}
