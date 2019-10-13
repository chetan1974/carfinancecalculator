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
     * @param loanAmout
     * @param numberOfPayments
     * @param paymentAmount
     * @return
     */
    float calculate(double loanAmout, int numberOfPayments, double paymentAmount);

    /**
     * Calculate number of payments.
     * @param loanAmout
     * @param annualInterestRate
     * @param paymentAmount
     * @return
     */
    int calculate(double loanAmout, float annualInterestRate, double paymentAmount);

    /**
     * Calculate loan amount.
     * @param numberOfPayments
     * @param annualInterestRate
     * @param paymentAmount
     * @return
     */
    double calculate(int numberOfPayments, float annualInterestRate, double paymentAmount);
}
