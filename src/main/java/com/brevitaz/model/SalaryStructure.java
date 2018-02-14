package com.brevitaz.model;

import java.util.ArrayList;
import java.util.List;

public class SalaryStructure {

    private String id;
    private List<SalaryComponent> salaryComponents = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SalaryComponent> getSalaryComponents() {
        return salaryComponents;
    }

    public void setSalaryComponents(List<SalaryComponent> salaryComponents) {
        this.salaryComponents = salaryComponents;
    }

    @Override
    public String toString() {
        return "SalaryStructure{" +
                "id='" + id + '\'' +
                ", salaryComponents=" + salaryComponents +
                '}';
    }
}
