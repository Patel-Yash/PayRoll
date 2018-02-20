package com.brevitaz.model;

public class Salary {

    private String eid;
    private String ssId;
    private double grossSalary;
    private double variablePay;
    private double otherAllowance;

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getSsId() {
        return ssId;
    }

    public void setSsId(String ssId) {
        this.ssId = ssId;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getVariablePay() {
        return variablePay;
    }

    public void setVariablePay(double variablePay) {
        this.variablePay = variablePay;
    }

    public double getOtherAllowance() {
        return otherAllowance;
    }

    public void setOtherAllowance(double otherAllowance) {
        this.otherAllowance = otherAllowance;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "eid='" + eid + '\'' +
                ", ssId='" + ssId + '\'' +
                ", grossSalary=" + grossSalary +
                ", variablePay=" + variablePay +
                ", otherAllowance=" + otherAllowance +
                '}';
    }
}
