package org.example;

import org.example.db.Database;
import org.example.entity.*;
import org.example.utils.SqlFileLoader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    private static final Connection DB_CONN = Database.getInstance().getConnection();

    public List<LongestProject> findLongestProjects() {
        List<LongestProject> longestProjectList = new ArrayList<>();

        try (Statement stm = DB_CONN.createStatement()) {
            String sql = SqlFileLoader.loadSQL("sql/find_longest_project.sql");

            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                LongestProject longestProject = new LongestProject(rs.getString("name"),
                        rs.getInt("month_count"));
                longestProjectList.add(longestProject);
            }
        } catch (SQLException e) {
            System.out.printf("Exception. Reason: %s%n", e.getMessage());
            throw new RuntimeException("Can not run query.");
        }

        return longestProjectList;
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> maxProjectsList = new ArrayList<>();

        try (Statement stm = DB_CONN.createStatement()) {
            String sql = SqlFileLoader.loadSQL("sql/find_max_projects_client.sql");

            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                MaxProjectCountClient maxProjectCountClient = new MaxProjectCountClient(rs.getString("name"),
                        rs.getInt("project_count"));
                maxProjectsList.add(maxProjectCountClient);
            }
        } catch (SQLException e) {
            System.out.printf("Exception. Reason: %s%n", e.getMessage());
            throw new RuntimeException("Can not run query.");
        }

        return maxProjectsList;
    }

    public List<MaxWorkerSalary> findMaxWorkerSalary() {
        List<MaxWorkerSalary> maxWorkersSalaryList = new ArrayList<>();

        try (Statement stm = DB_CONN.createStatement()) {
            String sql = SqlFileLoader.loadSQL("sql/find_max_salary_worker.sql");

            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                MaxWorkerSalary maxWorkerSalary = new MaxWorkerSalary(rs.getString("name"),
                        rs.getInt("salary"));
                maxWorkersSalaryList.add(maxWorkerSalary);
            }
        } catch (SQLException e) {
            System.out.printf("Exception. Reason: %s%n", e.getMessage());
            throw new RuntimeException("Can not run query.");
        }

        return maxWorkersSalaryList;
    }

    public List<WorkerBirthday> findYoungestEldestWorkers() {
        List<WorkerBirthday> yeWorkersList = new ArrayList<>();

        try (Statement stm = DB_CONN.createStatement()) {
            String sql = SqlFileLoader.loadSQL("sql/find_youngest_eldest_workers.sql");

            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                WorkerBirthday yeWorker = new WorkerBirthday(
                        rs.getString("type"),
                        rs.getString("name"),
                        LocalDate.parse(rs.getString("birthday")));
                yeWorkersList.add(yeWorker);
            }
        } catch (SQLException e) {
            System.out.printf("Exception. Reason: %s%n", e.getMessage());
            throw new RuntimeException("Can not run query.");
        }

        return yeWorkersList;
    }

    public List<ProjectPrice> getProjectPrices() {
        List<ProjectPrice> projectPricesList = new ArrayList<>();

        try (Statement stm = DB_CONN.createStatement()) {
            String sql = SqlFileLoader.loadSQL("sql/print_project_prices.sql");

            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ProjectPrice projectPrice = new ProjectPrice(rs.getString("name"),
                        rs.getInt("price"));
                projectPricesList.add(projectPrice);
            }
        } catch (SQLException e) {
            System.out.printf("Exception. Reason: %s%n", e.getMessage());
            throw new RuntimeException("Can not run query.");
        }

        return projectPricesList;
    }

}
