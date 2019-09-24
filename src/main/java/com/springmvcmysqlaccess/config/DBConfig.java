package com.springmvcmysqlaccess.config;


import com.mysqlaccess.MySQLAccess;
import com.mysqlaccess.models.MySQLAConfig;

public class DBConfig {

    static {
        MySQLAccess.logInfo();
        MySQLAccess.logDetails();
        MySQLAccess.logFetch();
    }

    public static MySQLAConfig get() {
        return AWS_JAVAEE;
    }

    public static MySQLAConfig AWS_JAVAEE = new MySQLAConfig(
            "java-projeto-db.cu3gs086dq8w.sa-east-1.rds.amazonaws.com",            // ---> Server I.P
            3306,                   // ---> Server port
            "javaee_at",        // ---> Database name
            "root",                 // ---> User name
            "rootroot"              // ---> Password
    );
}
