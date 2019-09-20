package com.mysqlaccess;

import com.mysqlaccess.models.MySQLAConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class MySQLA_connection {

//    private static final String serverTimeZone =
//                "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//    private static final String serverTimeZone =
//            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false";
//    private static Map<Connection, Long> lastMeasurement = new HashMap<>();
//    private static List<Connection> connections = new ArrayList<>();
//    private static final Long intervalInSeconds = 30l;

    private static final String serverTimeZone =
            "?useTimezone=true&serverTimezone=UTC";

    private static Map<MySQLAConfig, Connection> connectionsByConfig = new HashMap<>();
    private static Thread checkerThread = null;
    private static final int checkIntervalinSecs = 60;

    static {
        runCheckerThread();
        Runtime.getRuntime().addShutdownHook(new Thread( () -> {
            killConnections();
        }));
    }

    public static Connection getConnection(MySQLAConfig config) {

        if (connectionsByConfig.containsKey(config)) return connectionsByConfig.get(config);

        Connection conn = null;
        String url = "jdbc:mysql://" + config.ip + ":" + config.port + "/" + config.database + serverTimeZone;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, config.user, config.password);
            MySQLA_loggers.logInfo("CONNECTION - Successfully created connection to database " + config.database
                    + " @ " + config.ip + ":" + config.port + " with credentials " + config.user
                    + " | " + config.password + " || " + java.time.LocalDateTime.now().toString().replace("T",
                    " "));

            connectionsByConfig.put(config, conn);

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

    private static void runCheckerThread() {
        checkerThread = new Thread( () -> {
            while (true) {
                try {
                    Thread.sleep(checkIntervalinSecs*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                MySQLA_loggers.logInfo("CONNECTION - Checking connections status...");
                int aliveConnections = 0;
                synchronized (connectionsByConfig) {
                    for (Map.Entry<MySQLAConfig, Connection> entry : connectionsByConfig.entrySet()) {
                        Connection c = entry.getValue();
                        boolean isConnectionValid = false;
                        try {
                            isConnectionValid = c.isValid(5);
                        } catch (SQLException e) {
                            MySQLA_loggers.logError("CONNECTION - Connection error: " + e.getMessage());
                        }
                        if (isConnectionValid) aliveConnections++;
                    }
                }
                if (aliveConnections == connectionsByConfig.size()) {
                    MySQLA_loggers.logInfo("CONNECTION - " + aliveConnections + "/" + connectionsByConfig.size()
                            + " connections healthy.");
                }
                else {
                    MySQLA_loggers.logError("CONNECTION - " + (connectionsByConfig.size()-aliveConnections) + "/"
                            + connectionsByConfig.size() + " connections broken!");
                }
            }
        });
        checkerThread.setDaemon(true);
        checkerThread.start();
    }

//    private static void runCheckerThread() {
//        checkerThread = new Thread( () -> {
//            while (true) {
//                try {
//                    Thread.sleep(checkIntervalinSecs*1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                MySQLA_loggers.logInfo("CONNECTION - Checking connections status...");
//                int aliveConnections = 0;
//                synchronized (connections) {
//                    for (Connection c : connections) {
//                        boolean isConnectionValid = false;
//                        try {
//                            isConnectionValid = c.isValid(5);
//                        } catch (SQLException e) {
//                            MySQLA_loggers.logError("CONNECTION - Connection error: " + e.getMessage());
//                        }
//                        if (isConnectionValid) aliveConnections++;
//                    }
//                }
//                if (aliveConnections == connections.size()) {
//                    MySQLA_loggers.logInfo("CONNECTION - " + aliveConnections + "/" + connections.size()
//                            + " connections healthy.");
//                }
//                else {
//                    MySQLA_loggers.logError("CONNECTION - " + (connections.size()-aliveConnections) + "/"
//                            + connections.size() + " connections broken!");
//                }
//            }
//        });
//        checkerThread.setDaemon(true);
//        checkerThread.start();
//    }

    private static void killConnections() {
        for (Map.Entry<MySQLAConfig, Connection> entry : connectionsByConfig.entrySet()) {
            try {
                MySQLA_loggers.logInfo("CONNECTION - Killing connection.");
                entry.getValue().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection manageConnectionHealth(Connection conn, MySQLAConfig config) {
        return conn;
//        if (conn == null) return conn;
//        if (lastMeasurement.containsKey(conn)) {
//            if(new Date().getTime() - lastMeasurement.get(conn) > (intervalInSeconds*1000)) {
//                boolean isConnectionValid = false;
//                try {
//                    isConnectionValid = conn.isValid(5);
//                } catch (SQLException e) {
//                    MySQLA_loggers.logError(e.getMessage());
//                }
//                if (!isConnectionValid) {
//                    MySQLA_loggers.logInfo("CONNECTION - Checking connection health: EXPIRED. Attempting to reconnect...");
//                    lastMeasurement.remove(conn);
//                    conn = null;
//                    conn = getConnection(config);
//                }
//                if (conn == null) {
//                    MySQLA_loggers.logError("CONNECTION - Unable to reconnect.");
//                    return conn;
//                }
//                isConnectionValid = false;
//                try {
//                    isConnectionValid = conn.isValid(5);
//                } catch (SQLException e) {
//                    MySQLA_loggers.logError(e.getMessage());
//                }
//                if (!isConnectionValid) {
//                    MySQLA_loggers.logInfo("CONNECTION - Unable to reconnect. New connection is blocked.");
//                    return conn;
//                }
//                MySQLA_loggers.logInfo("CONNECTION - Checking connection health: VALID.");
//            }
//            lastMeasurement.replace(conn, new Date().getTime());
//            return conn;
//        }
//        return conn;
    }
}
