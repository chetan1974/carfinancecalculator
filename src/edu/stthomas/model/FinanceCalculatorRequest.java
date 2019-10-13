package edu.stthomas.model;

import edu.stthomas.enums.Attrbutes;

public class FinanceCalculatorRequest {
    private double loanAmount;
    private double paymentAmount;
    private float  annualInterestRate;
    private int numberOfPayments;
    private Attrbutes calculateAttribute;

    public FinanceCalculatorRequest() {}


    public FinanceCalculatorRequest(double loanAmount, double paymentAmount, float annualInterestRate, int numberOfPayments, Attrbutes calculateAttribute) {
        this.loanAmount = loanAmount;
        this.paymentAmount = paymentAmount;
        this.annualInterestRate = annualInterestRate;
        this.numberOfPayments = numberOfPayments;
        this.annualInterestRate = annualInterestRate;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public void setAnnualInterestRate(float annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setNumberOfPayments(int numberOfPayments) {
        this.numberOfPayments = numberOfPayments;
    }

    public void setCalculateAttribute(Attrbutes calculateAttribute) {
        this.calculateAttribute = calculateAttribute;
    }

    public double getLoanAmount(){
        return loanAmount;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public float getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getNumberOFPayments() {
        return numberOfPayments;
    }

    public Attrbutes getCalculateAttribute() {
        return calculateAttribute;
    }




}
