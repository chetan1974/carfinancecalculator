package edu.stthomas.carfinance;

public interface FinanceCalculatorIfc {

    /**
     * Calculate payment amount.
     * @param loanAmout
     * @param numberOfPayments
     * @param intrestRate
     * @return
     */
    double calculate(double loanAmout, int numberOfPayments, float intrestRate);

    /**
     * Calculate annual interest rate.
     * @param loanAmount
     * @param numberOfPayments
     * @param paymentAmount
     * @return
     */
    float calculate(double loanAmount, int numberOfPayments, double paymentAmount);

    /**
     * Calculate number of payments.
     * @param loanAmount
     * @param annualInterestRate
     * @param paymentAmount
     * @return
     */
    int calculate(double loanAmount, float annualInterestRate, double paymentAmount);

    /**
     * Calculate loan amount.
     * @param numberOfPayments
     * @param annualInterestRate
     * @param paymentAmount
     * @return
     */
    double calculate(int numberOfPayments, float annualInterestRate, double paymentAmount);
}
