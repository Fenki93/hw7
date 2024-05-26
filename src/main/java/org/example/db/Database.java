package org.example.db;

import org.example.utils.AppPropertyReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final Database INSTANCE = new Database();
    private final Connection connection;
    private Database() {
        try {
            String h2ConnectionUrl = AppPropertyReader.getConnectionUrlForH2();
            assert h2ConnectionUrl != null;
            this.connection = DriverManager.getConnection(h2ConnectionUrl);
        } catch (SQLException e) {
            throw new RuntimeException("Create connection exception. Reason: " + e.getMessage());
        }
    }

    public static Database getInstance(){
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }
}
