package org.example;

import org.example.db.Database;
import org.example.utils.SqlFileLoader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Arrays;

public class DatabasePopulateService {
    public static void main(String[] args) throws SQLException {
        populateDatabase();
    }

    public static void populateDatabase() throws SQLException {
        Connection dbH2Conn = Database.getInstance().getConnection();
        Statement stm = dbH2Conn.createStatement();

        String sql = SqlFileLoader.loadSQL("sql/populate_db.sql");
        stm.executeUpdate(sql);
    }

    public static void populateWorkers() throws SQLException {
        String[] names = new String[]{
                "King", "Santa", "Claus", "Bruce", "Willis","Alise", "Vik", "Tor", "Ajax", "Bill"};
        String[] bdays = new String[]{
                "2010-09-03", "2005-05-01", "2000-06-02", "2013-02-02", "2011-04-04",
                "2014-05-05", "1973-04-08", "1973-04-08", "1983-01-18", "1993-01-18"
        };
        String[] positions = new String[]{
                "Junior", "Middle", "Senior", "Trainee", "Junior", "Middle", "Senior", "Middle", "Senior", "Junior"};
        int[] salary = new int[]{700, 1400, 2800, 500, 750, 5000, 9000, 9000, 8500, 550};

        Connection dbH2Conn = Database.getInstance().getConnection();
        // ('King', '2010-09-03', 'Junior', 700)
        String sql = "INSERT INTO WORKER (NAME, BIRTHDATE, LEVEL, SALARY) VALUES (?, ?, ?, ?)";
        PreparedStatement stm = dbH2Conn.prepareStatement(sql);

        dbH2Conn.setAutoCommit(false);
        try {
            for(int i = 0; i < names.length; i++) {
                stm.setString(1, names[i]);
                stm.setString(2, bdays[i]);
                stm.setString(3, positions[i]);
                stm.setInt(4, salary[i]);
                stm.addBatch();
            }
            stm.executeBatch();
            dbH2Conn.commit();
        } catch(Exception ex) {
            dbH2Conn.rollback();
        } finally {
            dbH2Conn.setAutoCommit(true);
        }
    }

    public static void populateClients() throws SQLException {
        String[] clients = new String[]{"Nasa", "Nato", "Microsoft", "IBM", "Apple"};

        Connection dbH2Conn = Database.getInstance().getConnection();
        String sql = "INSERT INTO CLIENT (NAME) VALUES (?)";
        PreparedStatement stm = dbH2Conn.prepareStatement(sql);

        dbH2Conn.setAutoCommit(false);
        try {
            for(String client: clients) {
                stm.setString(1, client);
                stm.addBatch();
            }
            stm.executeBatch();
            dbH2Conn.commit();
        } catch(Exception ex) {
            dbH2Conn.rollback();
        } finally {
            dbH2Conn.setAutoCommit(true);
        }
    }

    public static void populateProjects() throws SQLException {
        int[] clientIds = new int[]{1, 2, 1, 4, 5, 1, 2, 3, 5, 5};
        String[] names = new String[]{
                "Project A", "Project B", "Project C", "Project D", "Project E",
                "Project F", "Project J", "Project K", "Project L", "Project M"
        };
        int[] months = new int[]{10, 7, 17, 21, 3, 12, 26, 26, 8, 6};
        LocalDate localDate = LocalDate.now();

        Connection dbH2Conn = Database.getInstance().getConnection();
        // (1, 'Project A', NOW(), DATEADD(MONTH, +10, NOW()))
        String sql = "INSERT INTO PROJECT (CLIENT_ID, NAME, START_DATE, FINISH_DATE) VALUES (?, ?, NOW(), ?)";
        PreparedStatement stm = dbH2Conn.prepareStatement(sql);

        dbH2Conn.setAutoCommit(false);
        try {
            for(int i = 0; i < clientIds.length; i++) {
                stm.setInt(1, clientIds[i]);
                stm.setString(2, names[i]);
                stm.setString(3, localDate.plusMonths(months[i]).toString());
                stm.addBatch();
            }
            stm.executeBatch();
            dbH2Conn.commit();
        } catch(Exception ex) {
            dbH2Conn.rollback();
            System.out.println("ex = " + ex);
        } finally {
            dbH2Conn.setAutoCommit(true);
        }
    }

    public static void populateProjectsWorkers() throws SQLException {
        int[] projectIds = new int[]{1,1,1,1,1,2,2,2,2,2,3,4,4,4,4,5,5,6,6,8,9,9,10,10};
        int[] workerIds  = new int[]{1,2,3,4,5,6,7,8,9,10,3,1,2,3,4,10,9,8,7,1,2,3,4,10};

        Connection dbH2Conn = Database.getInstance().getConnection();
        // (1,3)
        String sql = "INSERT INTO PROJECT_WORKER (PROJECT_ID, WORKER_ID) VALUES (?, ?)";
        PreparedStatement stm = dbH2Conn.prepareStatement(sql);

        dbH2Conn.setAutoCommit(false);
        try {
            for(int i = 0; i < projectIds.length; i++) {
                stm.setInt(1, projectIds[i]);
                stm.setInt(2, workerIds[i]);
                stm.addBatch();
            }
            stm.executeBatch();
            dbH2Conn.commit();
        } catch(Exception ex) {
            dbH2Conn.rollback();
            System.out.println("ex = " + ex);
        } finally {
            dbH2Conn.setAutoCommit(true);
        }
    }
}
