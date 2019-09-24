package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.DBConfig;
import com.springmvcmysqlaccess.config.Res;
import com.springmvcmysqlaccess.models.StudentUserViewModel;

import java.util.List;

public class StudentUserDao {

    private MySQLAccess studentsDb = new MySQLAccess(DBConfig.getDBConfig(), Res.STUDENTS_TABLE);
    private MySQLAccess usersDb = new MySQLAccess(DBConfig.getDBConfig(), Res.USERS_TABLE);

//    public Object add(Object p) {
//        return db.add(p);
//    }
//
//    public int update(User p) {
//        return db.update(p);
//    }
//
//    public int delete(int id) {
//        return db.delete(Res.USERS_TABLE_PK + "=" + id);
//    }

//    public User getUserById(int id) {
//        return db.getSingleItem(User.class, Res.USERS_TABLE_PK + "=" + id);
//    }
//
//    public User getUserByEmail(String email) {
//        return db.getSingleItem(User.class, "email='" + email + "'");
//    }
//
//    public User getUserByEnrollment(int enrollment) {
//        return db.getSingleItem(User.class, "enrollment='" + enrollment + "'");
//    }

    public List<StudentUserViewModel> getStudentUsers() {
        return studentsDb.getFill(
                StudentUserViewModel.class,
                new String[]{"userid_fk", "courseid_fk"},
                new String[]{Res.USERS_TABLE, Res.COURSES_TABLE}
                );
    }
}
