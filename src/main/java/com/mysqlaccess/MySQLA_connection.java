package com.mysqlaccess;

import com.mysqlaccess.models.MySQLAConfig;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MySQLA_connection {

    //        private static final String serverTimeZone =
//                "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

//    private static final String serverTimeZone =
//            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false";

    private static final String serverTimeZone =
            "?useTimezone=true&serverTimezone=UTC";

    private static Map<Connection, Long> lastMeasurement = new HashMap<>();
    private static final Long intervalInSeconds = 30l;

    public static Connection getConnection(MySQLAConfig config) {

        Connection conn = null;
        String url = "jdbc:mysql://" + config.ip + ":" + config.port + "/" + config.database + serverTimeZone;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, config.user, config.password);
            MySQLA_loggers.logInfo("CONNECTION - Successfully created connection to database " + config.database
                    + " @ " + config.ip + ":" + config.port + " with credentials " + config.user
                    + " | " + config.password);
            lastMeasurement.put(conn, new Date().getTime());

        } catch (SQLException e) {
            MySQLA_loggers.logError("CONNECTION - Unable to connect to database " + config.database + " @ "
                    + config.ip + ":" + config.port + " with credentials " + config.user + " | " + config.password);
            MySQLA_loggers.logError(e.getMessage());
        } catch (ClassNotFoundException e) {
            MySQLA_loggers.logError("CONNECTION - Unable to locate Java JDBC Driver.");
            MySQLA_loggers.logError(e.getMessage());
        }

        return conn;

    }

    public static Connection manageConnectionHealth(Connection conn, MySQLAConfig config) {
        if (conn == null) return conn;
        if (lastMeasurement.containsKey(conn)) {
//            System.out.println("Delay: " + (new Date().getTime() - lastMeasurement.get(conn) + " | intervalInSecs: " + intervalInSeconds*1000));
            if(new Date().getTime() - lastMeasurement.get(conn) > (intervalInSeconds*1000)) {
                boolean isConnectionValid = false;
                try {
                    isConnectionValid = conn.isValid(5);
                } catch (SQLException e) {
                    MySQLA_loggers.logError(e.getMessage());
                }
                if (!isConnectionValid) {
                    MySQLA_loggers.logInfo("CONNECTION - Checking connection health: EXPIRED. Attempting to reconnect...");
                    lastMeasurement.remove(conn);
                    conn = null;
                    conn = getConnection(config);
                }
                if (conn == null) {
                    MySQLA_loggers.logError("CONNECTION - Unable to reconnect.");
                    return conn;
                }
                isConnectionValid = false;
                try {
                    isConnectionValid = conn.isValid(5);
                } catch (SQLException e) {
                    MySQLA_loggers.logError(e.getMessage());
                }
                if (!isConnectionValid) {
                    MySQLA_loggers.logInfo("CONNECTION - Unable to reconnect. New connection is blocked.");
                    return conn;
                }
                MySQLA_loggers.logInfo("CONNECTION - Checking connection health: VALID.");
            }
            lastMeasurement.replace(conn, new Date().getTime());
            return conn;
        }
        return conn;
    }
}
