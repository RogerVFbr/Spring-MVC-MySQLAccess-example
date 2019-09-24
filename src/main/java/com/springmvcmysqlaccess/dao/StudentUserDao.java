package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.DBConfig;
import com.springmvcmysqlaccess.config.Res;
import com.springmvcmysqlaccess.models.StudentUserViewModel;
import com.springmvcmysqlaccess.models.Student;
import com.springmvcmysqlaccess.models.User;

import java.math.BigInteger;
import java.util.List;

public class StudentUserDao {

    private MySQLAccess studentsDb = new MySQLAccess(DBConfig.get(), Res.STUDENTS_TABLE);
    private MySQLAccess usersDb = new MySQLAccess(DBConfig.get(), Res.USERS_TABLE);

    public Object add(StudentUserViewModel p) {
        int userId = ((BigInteger) usersDb.add(p)).intValue();
        p.setUserid_fk(userId);
        studentsDb.add(p);
        return 1;
    }

    public int update(StudentUserViewModel studentUser) {
        studentsDb.update(studentUser);
        usersDb.update(studentUser);
        return 1;
    }

    public int delete(int id) {
        int userId = studentsDb.getSingleItem(Student.class, Res.STUDENTS_TABLE_PK + "=" + id).getStudentid();
        studentsDb.delete(Res.STUDENTS_TABLE_PK + "=" + id);
        usersDb.delete(Res.USERS_TABLE_PK + "=" + userId);
        return 1;
    }

    public StudentUserViewModel getStudentUserById(int id) {
        StudentUserViewModel studentUser = new StudentUserViewModel();

        Student student = studentsDb.getSingleItem(Student.class, Res.STUDENTS_TABLE_PK + "=" + id);
        studentUser.setBirthdate(student.getBirthdate());
        studentUser.setStudentid(student.getStudentid());
        studentUser.setUserid(student.getUserid_fk());
        studentUser.setUserid_fk(student.getUserid_fk());
        studentUser.setCourseid_fk(student.getCourseid_fk());

        User user = usersDb.getSingleItem(User.class, Res.USERS_TABLE_PK + "=" + student.getUserid_fk());
        studentUser.setEnrollment(user.getEnrollment());
        studentUser.setName(user.getName());
        studentUser.setPassword(user.getPassword());
        studentUser.setEmail(user.getEmail());
        studentUser.setProfileid_fk(user.getProfileid_fk());
        return studentUser;
    }

    public List<StudentUserViewModel> getStudentUsers() {
        return studentsDb.getFill(
                StudentUserViewModel.class,
                new String[]{"userid_fk", "courseid_fk"},
                new String[]{Res.USERS_TABLE, Res.COURSES_TABLE}
                );
    }
}
