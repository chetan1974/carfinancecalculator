package edu.stthomas.carfinance;

import edu.stthomas.enums.Attributes;
import edu.stthomas.model.Record;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

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
    private static List<Record>  records = new ArrayList<>();

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
        Record record = new Record(Attributes.MONTHLY_AMT, loanAmount, paymentAmount,annualInterestRate, numberOfPayments );
        records.add(record);
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
        double totalPayment = paymentAmount * numberOfPayments;
        double interestPaid = totalPayment - loanAmount;
        float apr = (float) ((interestPaid * numberOfPayments) / loanAmount);

        Record record = new Record(Attributes.ANNUAL_RATE, loanAmount, paymentAmount,apr, numberOfPayments );
        records.add(record);
        return apr;
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
        double intRatePerMonth = annualInterestRate/(12*100); //0.00375
        double paymentAmtByloanAmtByIntRate = paymentAmount/(loanAmount*intRatePerMonth); //6.081
        double onePlusRate = 1+intRatePerMonth; //1 + 0.00375 = 1.00375
        double step1 = paymentAmtByloanAmtByIntRate/(paymentAmtByloanAmtByIntRate-1); //6.081 / (6.081-1)=1.2
        int numberOfPayments = (int)( Math.log(step1)/Math.log(onePlusRate));

        Record record = new Record(Attributes.NUM_OF_PAYS, loanAmount, paymentAmount,annualInterestRate, numberOfPayments );
        records.add(record);
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
        Record record = new Record(Attributes.LOAN_AMOUNT, loanAmount, paymentAmount, annualInterestRate, numberOfPayments );
        records.add(record);
        return loanAmount;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("###.##");
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%1$-13s %2$-13s %3$-13s %4$-13s %5$-13s", "Calculate", "Principal", "APR", "Months", "Monthly amount")).append("\n");
        for(Record record: records) {
            String attribute = record.getCalculatedAttribute().toString();
            String principal = df.format(record.getLoanAmount());
            String apr = df.format(record.getAnnualInterestRate());
            String paymentAmt = df.format(record.getPaymentAmount());

            builder.append(String.format("%1$-13s %2$-13s %3$-13s %4$-13d %5$-13s", attribute, principal, apr, record.getNumberOfPayments(), paymentAmt));
            builder.append("\n");
        }
        builder.append("\n");
        return builder.toString();
    }
}
