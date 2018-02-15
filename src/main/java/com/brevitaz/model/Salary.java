package com.brevitaz.model;

public class Salary {

    private String id;
    //private String salaryStructureId;
    private double ctc;
    private double variablePay;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getCtc() {
        return ctc;
    }

    public void setCtc(double ctc) {
        this.ctc = ctc;
    }

    public double getVariablePay() {
        return variablePay;
    }

    public void setVariablePay(double variablePay) {
        this.variablePay = variablePay;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id='" + id + '\'' +
                ", ctc=" + ctc +
                ", variablePay=" + variablePay +
                '}';
    }
}
