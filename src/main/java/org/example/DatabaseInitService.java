package org.example;

import org.example.db.Database;
import org.example.utils.SqlFileLoader;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) throws SQLException {
        initDatabase();
    }

    public static void initDatabase() throws SQLException {
        System.out.println("H2 init data...");
        Connection dbH2Conn = Database.getInstance().getConnection();
        Statement stm = dbH2Conn.createStatement();

        String sql = SqlFileLoader.loadSQL("sql/init_db.sql");
        stm.execute(sql);
    }
}
