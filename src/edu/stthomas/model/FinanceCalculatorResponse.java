package edu.stthomas.model;

import edu.stthomas.enums.Status;

import java.util.ArrayList;
import java.util.List;
@Deprecated
public class FinanceCalculatorResponse {
    private double loanAmount;
    private double paymentAmount;
    private double  annualInterestRate;
    private int numberOfPayments;

    public FinanceCalculatorResponse() {

    }

    public FinanceCalculatorResponse(double loanAmount, double paymentAmount, double annualInterestRate, int numberOfPayments){
        this.loanAmount = loanAmount;
        this.paymentAmount = paymentAmount;
        this.annualInterestRate = annualInterestRate;
        this.numberOfPayments = numberOfPayments;
    }

    private List errors = new ArrayList();
    private Status status;

    public List getErrors() {
        return errors;
    }

    public Status getStatus() {
        return status;
    }

    public void addError(String error) {
        this.errors.add(error);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getLoanAmount(){
        return loanAmount;
    }

    public double getPaymentAmount(){
        return paymentAmount;
    }

    public double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public double getNumberOfPaymenys(){
        return numberOfPayments;
    }
}
