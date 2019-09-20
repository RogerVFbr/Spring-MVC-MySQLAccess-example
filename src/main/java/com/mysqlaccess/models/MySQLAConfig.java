package com.mysqlaccess.models;

import java.util.Objects;

public class MySQLAConfig {

    public String ip;
    public int port;
    public String database;
    public String user;
    public String password;

    public MySQLAConfig() {};

    public MySQLAConfig(String ip, int port, String database, String user, String password) {
        this.ip = ip;
        this.port = port;
        this.database = database;
        this.user = user;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MySQLAConfig that = (MySQLAConfig) o;
        return port == that.port &&
                ip.equals(that.ip) &&
                database.equals(that.database) &&
                user.equals(that.user) &&
                password.equals(that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, port, database, user, password);
    }
}
