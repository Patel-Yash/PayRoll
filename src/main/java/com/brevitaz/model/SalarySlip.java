package com.brevitaz.model;

public class SalarySlip {

    private String eid;
    private double variablePay;

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
                "eid='" + eid + '\'' +
                ", variablePay=" + variablePay +
                '}';
    }
}
