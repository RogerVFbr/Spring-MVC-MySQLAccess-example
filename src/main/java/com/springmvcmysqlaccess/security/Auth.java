package com.springmvcmysqlaccess.security;

import com.springmvcmysqlaccess.dao.UserDao;
import com.springmvcmysqlaccess.models.User;

public class Auth {

    private static UserDao dao = new UserDao();
    private static User currentUser = null;

    public static boolean login(String email, String password) {
        User dbUser = dao.getUserByEmail(email);
        if (dbUser!=null && password.equals(dbUser.getPassword())) {
            currentUser = dbUser;
            return true;
        }
        return false;
    }

    public static void logout() {
        currentUser = null;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static boolean isLoggedIn() {
        if (currentUser == null) return false;
        return true;
    }
}
