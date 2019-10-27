package edu.stthomas.model;
@Deprecated
public class RawInput {
    private String loanAmount;
    private String paymentAmount;
    private String  annualInterestRate;
    private String numberOfPayments;

    public RawInput(String loanAmount, String paymentAmount, String annualInterestRate, String numberOfPayments) {
        this.loanAmount = loanAmount;
        this.paymentAmount = paymentAmount;
        this.annualInterestRate = annualInterestRate;
        this.numberOfPayments = numberOfPayments;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public String getAnnualInterestRate() {
        return annualInterestRate;
    }

    public String getNumberOfPayments() {
        return numberOfPayments;
    }
}
