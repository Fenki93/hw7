package org.example.entity;

public class LongestProject {
    private String name;
    private int monthCount;

    public LongestProject(String name, int monthCount) {
        this.name = name;
        this.monthCount = monthCount;
    }

    public String getName() {
        return name;
    }

    public int getMonthCount() {
        return monthCount;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "Name='" + name + '\'' +
                ", Month count=" + monthCount +
                '}';
    }
}
