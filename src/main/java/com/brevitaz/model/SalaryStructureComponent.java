package com.brevitaz.model;

import java.util.ArrayList;
import java.util.List;

public class SalaryStructureComponent {

    private String id;
    private String name;
    private enum type {percentage,fixValue;}
    private double value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SalaryStructureComponent{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
