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

    private MySQLAccess studentsDb = new MySQLAccess(DBConfig.getDBConfig(), Res.STUDENTS_TABLE);
    private MySQLAccess usersDb = new MySQLAccess(DBConfig.getDBConfig(), Res.USERS_TABLE);

    public Object add(StudentUserViewModel p) {
        User user = new User ();
        user.setEnrollment(p.getEnrollment());
        user.setName(p.getName());
        user.setPassword(p.getPassword());
        user.setEmail(p.getEmail());
        user.setProfileid_fk(p.getProfileid_fk());

        int userId = ((BigInteger) usersDb.add(user)).intValue();
        Student student = new Student();
        student.setUserid_fk(userId);
        student.setBirthdate(p.getBirthdate());
        student.setCourseid_fk(p.getCourseid_fk());
        studentsDb.add(student);
        return 1;
    }

    public int update(StudentUserViewModel studentUser) {
        Student student = new Student();
        student.setStudentid(studentUser.getStudentid());
        student.setBirthdate(studentUser.getBirthdate());
        student.setUserid_fk(studentUser.getUserid_fk());
        student.setCourseid_fk(studentUser.getCourseid_fk());
        studentsDb.update(student);

        User user = new User();
        user.setUserid(studentUser.getUserid());
        user.setEnrollment(studentUser.getEnrollment());
        user.setName(studentUser.getName());
        user.setPassword(studentUser.getPassword());
        user.setEmail(studentUser.getEmail());
        user.setProfileid_fk(studentUser.getProfileid_fk());
        usersDb.update(user);

        return 1;
    }
//
//    public int delete(int id) {
//        return db.delete(Res.USERS_TABLE_PK + "=" + id);
//    }

    public StudentUserViewModel getStudentUserById(int id) {
        StudentUserViewModel studentUser = new StudentUserViewModel();
        Student student = studentsDb.getSingleItem(Student.class, Res.STUDENTS_TABLE_PK + "=" + id);
        studentUser.setBirthdate(student.getBirthdate());
        studentUser.setStudentid(student.getStudentid());
        studentUser.setUserid(student.getUserid_fk());
        studentUser.setCourseid_fk(student.getCourseid_fk());
        User user = usersDb.getSingleItem(User.class, Res.USERS_TABLE_PK + "=" + student.getUserid_fk());
        studentUser.setEnrollment(user.getEnrollment());
        studentUser.setName(user.getName());
        studentUser.setEmail(user.getEmail());
        studentUser.setProfileid_fk(user.getProfileid_fk());
        return studentUser;
    }
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
