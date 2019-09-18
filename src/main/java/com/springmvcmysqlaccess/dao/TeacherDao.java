package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.Res;
import com.springmvcmysqlaccess.models.Teacher;

import java.util.List;

public class TeacherDao {

    private MySQLAccess db = DBAccess.getAccess();

    public Object add(Teacher p) {
        db.setTable(Res.TEACHERS_TABLE);
        return db.add(p);
    }

    public int update(Teacher p) {
        db.setTable(Res.TEACHERS_TABLE);
        return db.update(p);
    }

    public int delete(int id) {
        db.setTable(Res.TEACHERS_TABLE);
        return db.delete(Res.TEACHERS_TABLE_PK + "=" + id);
    }

    public Teacher getTeacherById(int id) {
        db.setTable(Res.TEACHERS_TABLE);
        return db.getSingleItem(Teacher.class, Res.TEACHERS_TABLE_PK + "=" + id);
    }

    public List<Teacher> getTeachers() {
        db.setTable(Res.TEACHERS_TABLE);
        return db.get(Teacher.class);
    }
}
