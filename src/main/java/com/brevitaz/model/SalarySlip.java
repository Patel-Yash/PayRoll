package com.brevitaz.model;

public class SalarySlip {

    private String id;
    private String eid;
    private double variablePay;

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

    @Override
    public String toString() {
        return "SalarySlip{" +
                "id='" + id + '\'' +
                ", eid='" + eid + '\'' +
                ", variablePay=" + variablePay +
                '}';
    }
}
