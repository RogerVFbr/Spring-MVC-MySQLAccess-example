package com.mysqlaccess;

import com.mysqlaccess.models.MySQLAConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MySQLA_crud_getMain {

    public static <T> List<T> getMain(Class<T> type, Connection conn, MySQLAConfig config, String table,
                                      String sqlWhereFilter, OnGetComplete<List<T>> callback) {

        List<T> returnData = new ArrayList<>();
        String database = config.database;

        // ---> If no connection has been established, abort.
        if (!MySQLA_validators.hasConnection(conn)) {
            MySQLA_loggers.logError("GET - Unable to execute command because there is no connection to '" +
                    database + "' database.");
            if (callback != null) callback.onFailure();
            return null;
        }

        // ---> If connection is invalid, attempt to reconnect, abort if unable;
        conn = MySQLA_connection.manageConnectionHealth(conn, config);
        if (conn == null) {
            MySQLA_loggers.logError("GET - Unable to execute command because the connection to '" +
                    database + "' database has expired and reconnection failed.");
            if (callback != null) callback.onFailure();
            return null;
        }

        boolean isValid = false;
        try {
            isValid = conn.isValid(3);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(isValid) {
            System.out.println("connection is valid");
        } else {
            System.out.println("connection is invalid");
        }

        // ---> If no table is selected, abort.
        if (!MySQLA_validators.isTableSelected(table)) {
            MySQLA_loggers.logError("GET - No table selected on database '" + database
                    + "'. Use setTable(..tablename..) before executing mysqlaccess commands.");
            if (callback != null) callback.onFailure();
            return null;
        }

        // ---> Get table properties if not already present.
        MySQLA_tableProperties.updateTableProperties(database, conn, table);

        // ---> If table properties could not be fetched, abort
        if (!MySQLA_validators.hasFetchedTableDetails(database, table)) {
            MySQLA_loggers.logError("GET - Could not fetch table details from database.");
            if (callback != null) callback.onFailure();
            return null;
        }

        // ---> Build or get column/field correlation map
        Map<String, String> propertyMap = MySQLA_correlations.getColumnFieldCorrelation(
                type,
                MySQLA_tableProperties.getAllColumns(database, table),
                database,
                table);

        // ---> Build SQL query
        String query = buildSQLQuery(table, sqlWhereFilter, propertyMap);

        // ---> Retrieve data from cache if caching is enabled and available
        List<T> cacheData = null;
        cacheData = MySQLA_cache.isCacheAvailable(database, table, query);
        if (cacheData != null) {
            if (callback != null) callback.onSuccess(cacheData);
            return cacheData;
        };

        // ---> Execute query on connection
        ResultSet resultSet = executeQueryOnConnection(conn, table, query, callback);

        // ---> Build list from retrieved data
        if (!MySQLA_listBuilder.buildListFromRetrievedData(type, resultSet, returnData, propertyMap)) {
            if (callback != null) callback.onFailure();
            return returnData;
        };

        // ---> Store result to cache if available and return.
        MySQLA_cache.storeToCache(database, table, query, returnData);
        if (callback != null) callback.onSuccess(returnData);
        return returnData;
    }

    public static <T> void getMainParallel(Class<T> type, Connection conn, MySQLAConfig config, String table,
                                      String sqlWhereFilter, OnGetComplete<List<T>> callback) {
        Thread t = new Thread( () -> {
            getMain(type, conn, config, table, sqlWhereFilter, callback);
        });
        t.start();
    }

    public static <T> T getSingleItem(Class<T> type, Connection conn, MySQLAConfig config, String table,
                                           String sqlWhereFilter, OnGetComplete<List<T>> callback) {
        List<T> returnData = getMain(type, conn, config, table, sqlWhereFilter, callback);
        if (returnData.size()>0) return returnData.get(0);
        return null;
    }

    public static <T> void getSingleItemParallel(Class<T> type, Connection conn,  MySQLAConfig config, String table,
                                      String sqlWhereFilter, OnGetComplete<T> callback) {
        Thread t = new Thread( () -> {
            List<T> returnData = getMain(type, conn, config, table, sqlWhereFilter, null);
            if (returnData.size()>0) {
                if (callback != null) callback.onSuccess(returnData.get(0));
            };
        });
        t.start();
    }

    private static <T> String buildSQLQuery (String table, String sqlWhereFilter, Map<String, String> propertyMap) {

        // ---> Build SQL query
        List<String> columns = new ArrayList<>(propertyMap.keySet());
        String columnNames = columns == null || columns.size() == 0 ? "*" : String.join(", ", columns);
        String query = "select " + columnNames + " from " + table;
        if (sqlWhereFilter != null) query += " where " + sqlWhereFilter;
        return query;
    }

    private static <T> ResultSet executeQueryOnConnection (Connection conn, String table,
                                                    String query, OnGetComplete<T> callback) {
        // ---> Execute query on connection
        ResultSet resultSet = null;
        try {
            Statement st = conn.createStatement();
            MySQLA_loggers.logInfo("GET - Executing get query at '" + table +"': " + query);
            resultSet = st.executeQuery(query);

        } catch (SQLException e) {
            MySQLA_loggers.logError("GET - Unable to create connection statement.");
            MySQLA_loggers.logError(e.getMessage());
            MySQLA_loggers.logError(e.getSQLState());

            if (callback != null) callback.onFailure();
            e.printStackTrace();
        }
        return resultSet;
    }
}
