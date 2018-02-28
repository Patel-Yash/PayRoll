package com.brevitaz.model;

import java.util.ArrayList;
import java.util.List;

public class SalaryStructureComponent {

    private String id;
    private String displayName;
    private String name;
    private Type type;
    private double value;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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
                ", displayName='" + displayName + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", value=" + value +
                '}';
    }

}
