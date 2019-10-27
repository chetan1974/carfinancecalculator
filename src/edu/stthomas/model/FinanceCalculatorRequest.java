package edu.stthomas.model;

import edu.stthomas.enums.Attributes;
@Deprecated()
public class FinanceCalculatorRequest {
    private double loanAmount;
    private double paymentAmount;
    private float  annualInterestRate;
    private int numberOfPayments;
    private Attributes calculateAttribute;

    public FinanceCalculatorRequest() {}


    public FinanceCalculatorRequest(double loanAmount, double paymentAmount, float annualInterestRate, int numberOfPayments, Attributes calculateAttribute) {
        this.loanAmount = loanAmount;
        this.paymentAmount = paymentAmount;
        this.annualInterestRate = annualInterestRate;
        this.numberOfPayments = numberOfPayments;
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * calculate monthly payment
     * @param loanAmount
     * @param annualInterestRate
     * @param numberOfPayments
     */
    public FinanceCalculatorRequest(double loanAmount, float annualInterestRate, int numberOfPayments) {
        this.loanAmount = loanAmount;
        this.annualInterestRate = annualInterestRate;
        this.numberOfPayments = numberOfPayments;
        this.annualInterestRate = annualInterestRate;
        this.calculateAttribute = Attributes.MONTHLY_AMT;
    }


    /**
     * calculate ANNUAL_RATE
     * @param loanAmount
     * @param paymentAmount
     * @param numberOfPayments
     */
    public FinanceCalculatorRequest(double loanAmount, double paymentAmount, int numberOfPayments) {
        this.loanAmount = loanAmount;
        this.annualInterestRate = annualInterestRate;
        this.numberOfPayments = numberOfPayments;
        this.paymentAmount = paymentAmount;
        this.calculateAttribute = Attributes.MONTHLY_AMT;
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

    public void setCalculateAttribute(Attributes calculateAttribute) {
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

    public Attributes getCalculateAttribute() {
        return calculateAttribute;
    }




}
