package com.brevitaz.model;

import java.util.ArrayList;
import java.util.List;

public class SalarySlip {
    private String id;
    private String eid;
    private double variablePay;

    private List<SalaryDeductionComponent> salaryDeductionComponents = new ArrayList<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public double getVariablePay() {
        return variablePay;
    }

    public void setVariablePay(double variablePay) {
        this.variablePay = variablePay;
    }

    public List<SalaryDeductionComponent> getSalaryDeductionComponents() {
        return salaryDeductionComponents;
    }

    public void setSalaryDeductionComponents(List<SalaryDeductionComponent> salaryDeductionComponents) {
        this.salaryDeductionComponents = salaryDeductionComponents;
    }

    @Override
    public String toString() {
        return "SalarySlip{" +
                "id='" + id + '\'' +
                ", eid='" + eid + '\'' +
                ", variablePay=" + variablePay +
                ", salaryDeductionComponents=" + salaryDeductionComponents +
                '}';
    }
}
