package com.springmvcmysqlaccess.dao;

import com.mysqlaccess.MySQLAccess;
import com.springmvcmysqlaccess.config.DBConfig;
import com.springmvcmysqlaccess.models.ClassMdl;

import java.util.List;

public class ClassMdlDao {

    private MySQLAccess table = new MySQLAccess(DBConfig.AWS_JAVAEE, "class");
    private String primaryKeyColumnName = "classid";

    public Object add(ClassMdl p) {
        return table.add(p);
    }

    public int update(ClassMdl p) {
        return table.update(p);
    }

    public int delete(int id) {
        return table.delete(primaryKeyColumnName + "=" + id);
    }

    public ClassMdl getClassById(int id) {
        return table.getSingleItem(ClassMdl.class,
                primaryKeyColumnName + "=" + id);
    }

    public List<ClassMdl> getClasses() {
        return table.get(ClassMdl.class);
    }
}
