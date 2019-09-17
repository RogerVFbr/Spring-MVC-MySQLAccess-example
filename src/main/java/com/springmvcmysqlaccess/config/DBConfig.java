package com.springmvcmysqlaccess.config;


import com.mysqlaccess.MySQLAccess;
import com.mysqlaccess.models.MySQLAConfig;

public class DBConfig {

    static {
        MySQLAccess.logInfo();
        MySQLAccess.logDetails();
//        MySQLAccess.logFetch();
    }

    public static MySQLAConfig getDBConfig() {
        return AWS;
    }

    private static MySQLAConfig LOCAL = new MySQLAConfig(
            "127.0.0.1",             // ---> Server I.P
            3306,                  // ---> Server port
            "springdb",        // ---> Database name
            "root",                 // ---> User name
            "RogerRootPass"              // ---> Password
    );

    private static MySQLAConfig XQUBE = new MySQLAConfig(
            "127.0.0.1",            // ---> Server I.P
            3306,                   // ---> Server port
            "springdb",        // ---> Database name
            "root",                 // ---> User name
            "root"              // ---> Password
    );

    private static MySQLAConfig AWS = new MySQLAConfig(
            "java-projeto-db.cu3gs086dq8w.sa-east-1.rds.amazonaws.com",            // ---> Server I.P
            3306,                   // ---> Server port
            "java_projeto_db",        // ---> Database name
            "root",                 // ---> User name
            "rootroot"              // ---> Password
    );

    public static MySQLAConfig AWS_JAVAEE = new MySQLAConfig(
            "java-projeto-db.cu3gs086dq8w.sa-east-1.rds.amazonaws.com",            // ---> Server I.P
            3306,                   // ---> Server port
            "javaee_at",        // ---> Database name
            "root",                 // ---> User name
            "rootroot"              // ---> Password
    );
}
