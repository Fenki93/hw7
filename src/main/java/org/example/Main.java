package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseInitService.initDatabase();
        // populate db tables with prepared+batch+transaction
        DatabasePopulateService.populateWorkers();
        DatabasePopulateService.populateClients();
        DatabasePopulateService.populateProjects();
        DatabasePopulateService.populateProjectsWorkers();
        // populate db with sql files
//        DatabasePopulateService.populateDatabase();


        DatabaseQueryService dbService = new DatabaseQueryService();

        System.out.println("Find longest projects...");
        System.out.println(dbService.findLongestProjects());

        System.out.println("Find max projects client...");
        System.out.println(dbService.findMaxProjectsClient());

        System.out.println("Find max workers salary...");
        System.out.println(dbService.findMaxWorkerSalary());

        System.out.println("Find youngest-eldest workers...");
        System.out.println(dbService.findYoungestEldestWorkers());

        System.out.println("Get project prices...");
        System.out.println(dbService.getProjectPrices());
    }
}