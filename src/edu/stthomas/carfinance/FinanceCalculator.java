package edu.stthomas.carfinance;

/**
 * loanamount,  numberOfPayments    annualInterestRate  paymentAmount
 * double,         int,                float,              double
 *
 * double, int, float
 * double, int, double
 * double, float, double
 * int, float, double
 *
 * Ref: https://www.vertex42.com/ExcelArticles/amortization-calculation.html
 */
public class FinanceCalculator implements FinanceCalculatorIfc {
    /**
     * calculate payment amount
     * @param loanAmount
     * @param numberOfPayments
     * @param annualInterestRate
     * @return
     */
    @Override
    public double calculate(double loanAmount, int numberOfPayments, float annualInterestRate){
        annualInterestRate = annualInterestRate / (12 * 100);
        double paymentAmount = (loanAmount) * (annualInterestRate * Math.pow(1 + annualInterestRate, numberOfPayments))
                /(Math.pow(1 + annualInterestRate, numberOfPayments) - 1);
        return paymentAmount;
    }

    /**
     * calculate annual interest rate
     * @param loanAmount
     * @param numberOfPayments
     * @param paymentAmount
     * @return
     * https://www.calculatorsoup.com/calculators/financial/compound-interest-calculator.php
     */
    @Override
    public float calculate(double loanAmount, int numberOfPayments, double paymentAmount){
        float annualInterestRate = (float) ((loanAmount / paymentAmount) * (12.00/numberOfPayments));
        return annualInterestRate;
    }

    /**
     * calculate number of payments
     * @param loanAmount
     * @param annualInterestRate
     * @param paymentAmount
     * @return
     */
    @Override
    public int calculate(double loanAmount, float annualInterestRate, double paymentAmount){
        int numberOfPayments  =  (int) ((annualInterestRate / paymentAmount ) * loanAmount);
        return numberOfPayments;
    }

    /**
     * calculate loan amount.
     * Ref: https://www.vertex42.com/ExcelArticles/amortization-calculation.html
     * @param numberOfPayments
     * @param annualInterestRate
     * @param paymentAmount
     * @return
     */
    @Override
    public double calculate(int numberOfPayments, float annualInterestRate, double paymentAmount){
        annualInterestRate = annualInterestRate / (12 * 100);
        double loanAmount = paymentAmount * ((Math.pow(1 + annualInterestRate, numberOfPayments) - 1))
                / (annualInterestRate * Math.pow(1 + annualInterestRate, numberOfPayments));
        return loanAmount;
    }
}
