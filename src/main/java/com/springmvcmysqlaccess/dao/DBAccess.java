package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.DBConfig;

public class DBAccess {

    private static MySQLAccess accessor = new MySQLAccess(DBConfig.getDBConfig());

    public static MySQLAccess getAccess() {
        return accessor;
    }
}
