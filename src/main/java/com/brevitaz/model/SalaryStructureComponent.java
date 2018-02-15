package com.brevitaz.model;

import java.util.ArrayList;
import java.util.List;

public class SalaryStructureComponent {

    private String id;
    private String name;
    private Type type;
    private double value;

    private enum Type {percentage,fixValue;}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
                ", type=" + type +
                ", value=" + value +
                '}';
    }
}
