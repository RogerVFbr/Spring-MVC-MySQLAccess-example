package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.DBConfig;
import com.springmvcmysqlaccess.config.Res;
import com.springmvcmysqlaccess.models.*;

import java.math.BigInteger;
import java.util.List;

public class TeacherUserDao {

    private MySQLAccess teachersDb = new MySQLAccess(DBConfig.get(), Res.TEACHERS_TABLE);
    private MySQLAccess usersDb = new MySQLAccess(DBConfig.get(), Res.USERS_TABLE);

    public Object add(TeacherUserViewModel p) {
        int userId = ((BigInteger) usersDb.add(p)).intValue();
        p.setUserid_fk(userId);
        teachersDb.add(p);
        return 1;
    }

    public int update(TeacherUserViewModel teacherUser) {
        teachersDb.update(teacherUser);
        usersDb.update(teacherUser);
        return 1;
    }

    public int delete(int id) {
        int userId = teachersDb.getSingleItem(Teacher.class, Res.TEACHERS_TABLE_PK + "=" + id).getTeacherid();
        teachersDb.delete(Res.TEACHERS_TABLE_PK + "=" + id);
        usersDb.delete(Res.USERS_TABLE_PK + "=" + userId);
        return 1;
    }

    public TeacherUserViewModel getTeacherUserById(int id) {
        TeacherUserViewModel teacherUser = new TeacherUserViewModel();

        Teacher teacher = teachersDb.getSingleItem(Teacher.class, Res.TEACHERS_TABLE_PK + "=" + id);
        teacherUser.setTeacherid(teacher.getTeacherid());
        teacherUser.setTitle(teacher.getTitle());
        teacherUser.setUserid_fk(teacher.getUserid_fk());
        teacherUser.setUserid(teacher.getUserid_fk());

        User user = usersDb.getSingleItem(User.class, Res.USERS_TABLE_PK + "=" + teacher.getUserid_fk());
        teacherUser.setEnrollment(user.getEnrollment());
        teacherUser.setName(user.getName());
        teacherUser.setPassword(user.getPassword());
        teacherUser.setEmail(user.getEmail());
        teacherUser.setProfileid_fk(user.getProfileid_fk());
        return teacherUser;
    }

    public List<TeacherUserViewModel> getTeacherUsers() {
        return teachersDb.getFill(TeacherUserViewModel.class, "userid_fk",  Res.USERS_TABLE);
    }

}
