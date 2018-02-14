package com.brevitaz.model;

import java.util.ArrayList;
import java.util.List;

public class SalaryStructure {

    private String id;
    private List<SalaryStructureComponent> salaryStructureComponents = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SalaryStructureComponent> getSalaryComponents() {
        return salaryStructureComponents;
    }

    public void setSalaryComponents(List<SalaryStructureComponent> salaryComponents) {
        this.salaryStructureComponents = salaryComponents;
    }

    @Override
    public String toString() {
        return "SalaryStructure{" +
                "id='" + id + '\'' +
                ", salaryComponents=" + salaryStructureComponents +
                '}';
    }
}
