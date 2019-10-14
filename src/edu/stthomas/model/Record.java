package edu.stthomas.model;

import edu.stthomas.enums.Attributes;

public class Record {
    private double loanAmount;
    private double paymentAmount;
    private float  annualInterestRate;
    private int numberOfPayments;
    private Attributes calculatedAttribute;

    public Record(Attributes calculatedAttribute, double loanAmount, double paymentAmount, float annualInterestRate, int numberOfPayments){
        this.calculatedAttribute = calculatedAttribute;
        this.loanAmount = loanAmount;
        this.paymentAmount = paymentAmount;
        this.annualInterestRate = annualInterestRate;
        this.numberOfPayments = numberOfPayments;
    }

    public Attributes getCalculatedAttribute() {
        return calculatedAttribute;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public int getNumberOfPayments() {
        return numberOfPayments;
    }

    public float getAnnualInterestRate() {
        return annualInterestRate;
    }
}
