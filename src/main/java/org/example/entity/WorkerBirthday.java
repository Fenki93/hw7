package org.example.entity;

import java.time.LocalDate;

public class WorkerBirthday {
    private String  type;
    private String name;
    private LocalDate birthday;

    public WorkerBirthday(String type, String name, LocalDate birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }

    public String getType() {
        return type;
    }
    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "WorkerBirthday{" +
                "Type='" + type + '\'' +
                ", Name='" + name + '\'' +
                ", Birthday=" + birthday.toString() +
                '}';
    }
}
