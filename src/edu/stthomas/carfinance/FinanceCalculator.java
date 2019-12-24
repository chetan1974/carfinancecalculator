package edu.stthomas.carfinance;

import edu.stthomas.util.Helper;

/**
 * Calculation service class. Seperation of responsibility of just calculating the required attribute.
 * Ref formula: https://www.vertex42.com/ExcelArticles/amortization-calculation.html
 * https://financial-calculators.com/loan-calculator
 */
public class FinanceCalculator implements FinanceCalculatorIfc {
    /**
     * calculate payment amount.
     * @param loanAmount
     * @param numberOfPayments
     * @param annualInterestRate
     * @return
     */
    @Override
    public double calculate(double loanAmount, int numberOfPayments, float annualInterestRate){
        float monthlyInterestRate = annualInterestRate / (12 * 100);
        double paymentAmount;
        if(annualInterestRate == 0f) {
            //special case where rate is zero
            paymentAmount = loanAmount/numberOfPayments;
            paymentAmount = Helper.formatTwoDigit(paymentAmount);
        } else {
            //use normal formula
            paymentAmount = Helper.roundUp(loanAmount) * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                    / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
            paymentAmount = Helper.roundUp(paymentAmount);
        }

        return paymentAmount;
    }

    /**
     * calculate annual interest rate. Interest is assumed some value and compared to check accuracy until desired
     * result of interest rate is calculated with tolerance.
     *
     * @param loanAmount
     * @param numberOfPayments
     * @param paymentAmount
     * @return
     */
    @Override
    public float calculate(double loanAmount, int numberOfPayments, double paymentAmount){
        Long startTime  = System.currentTimeMillis();
        float intRate = 0.000f;
        double calculatedPaymentAmount = -1.0;

        //use recursion to get closer to the payment amount.
        boolean decrement = false;
        boolean increment = false;
        while(Math.abs(paymentAmount - calculatedPaymentAmount) > 1.0) {
            calculatedPaymentAmount = calculate(loanAmount, numberOfPayments, intRate);
                if (calculatedPaymentAmount > paymentAmount) {
                    decrement = true;
                    intRate -= 0.0001;
                } else {
                    increment = true;
                    intRate += 0.0001;
                }
                //avoid indefinite loop if diff between calculatedPaymentAmount and paymentAmount is always greater than 1.
                if(decrement && increment) {
                    System.out.println("increment and decrement found");
                    break;
                }
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("Time for calculating int rate:" +(endTime - startTime) +" millis");

        return (float) Helper.formatTwoDigit(intRate);
    }

    /**
     * calculate number of payments.
     * https://www.vertex42.com/ExcelArticles/amortization-calculation.html
     * @param loanAmount
     * @param annualInterestRate
     * @param paymentAmount
     * @return
     */
    @Override
    public int calculate(double loanAmount, float annualInterestRate, double paymentAmount){
        double intRatePerMonth = annualInterestRate/(12*100); //0.00375
        double paymentAmtByloanAmtByIntRate = paymentAmount/(loanAmount*intRatePerMonth); //step 1
        double onePlusRate = 1 + intRatePerMonth;
        double step1 = paymentAmtByloanAmtByIntRate/(paymentAmtByloanAmtByIntRate-1); //6.081 / (6.081-1)=1.2
        int numberOfPayments = (int)( Math.log(step1)/Math.log(onePlusRate));

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
