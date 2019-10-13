package edu.stthomas.util;

import edu.stthomas.enums.Attrbutes;
import edu.stthomas.model.FinanceCalculatorRequest;
import edu.stthomas.model.RawInput;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ValidationService {
    final String EMPTY = " ";
    List<String> errorMsgs = new ArrayList<>();

    /**
     * converts raw inouts, validates and returns a FinanceCalculatorRequest only when all the input is valid for further
     * calculations.
     * @param rawInput
     * @return validationObject
     */
//    public ValidationObject convertInput(RawInput rawInput) {
//        ValidationObject validationObject = new ValidationObject();
//        //check all the inputs..if valid return status success or else retuen fail
//        return validationObject;
//    }

//    public List<String> validate(RawInput rawInput) {
    public FinanceCalculatorRequest validate(RawInput rawInput) {

        //check and convert to FinanceCalculatorRequest object.
        String rawLoanAmount = rawInput.getLoanAmount();
        String rawNumberOfPayments = rawInput.getNumberOfPayments();
        String rawAnnualInterestRate = rawInput.getAnnualInterestRate();
        String rawPaymentAmount = rawInput.getPaymentAmount();

        FinanceCalculatorRequest financeCalculatorRequest = new FinanceCalculatorRequest();
        financeCalculatorRequest.setCalculateAttribute(Attrbutes.NONE);
        int emptyCount = 0;
        if(rawLoanAmount.equals(EMPTY)) {
            emptyCount++;
            financeCalculatorRequest.setLoanAmount(0);
            financeCalculatorRequest.setCalculateAttribute(Attrbutes.LOAN_AMOUNT);
        } else {
            financeCalculatorRequest.setLoanAmount(Double.valueOf(rawLoanAmount));
        }

        if(rawNumberOfPayments.equals(EMPTY)) {
            emptyCount++;
            financeCalculatorRequest.setNumberOfPayments(0);
            financeCalculatorRequest.setCalculateAttribute(Attrbutes.NUMBER_OF_PAYMENTS);
        }else {
            Integer numberOfPayments = Integer.valueOf(rawNumberOfPayments);
            if((2 > numberOfPayments) || (numberOfPayments > 72)) {
                throw new NumberFormatException("number of payments should be in range of 2 to 72");
            }
            financeCalculatorRequest.setNumberOfPayments(numberOfPayments);
        }

        if(rawAnnualInterestRate.equals(EMPTY)) {
            emptyCount++;
            financeCalculatorRequest.setCalculateAttribute(Attrbutes.ANNUAL_INTEREST_RATE);
        } else {
            float annualInterestRate = Float.valueOf(rawAnnualInterestRate);
            if(annualInterestRate < 0) {
                throw new NumberFormatException("annual interest should be greater than 0");
            }
            financeCalculatorRequest.setAnnualInterestRate(annualInterestRate);
        }

        if(rawPaymentAmount.equals(EMPTY)) {
            emptyCount++;
            financeCalculatorRequest.setCalculateAttribute(Attrbutes.PAYMENT_AMOUNT);
        } else {
            Double paymentAmount = Double.valueOf(rawPaymentAmount);
            if(paymentAmount == 0) {
                throw new NumberFormatException("payment amount of zero is not acceptable");
            }
            financeCalculatorRequest.setPaymentAmount(paymentAmount);
        }

        if(emptyCount == 0) {
            errorMsgs.add("Atleast one variable should contain "+ EMPTY + " value");
            System.out.println("Atleast one variable should contain "+ EMPTY + " value");
        }

        if(emptyCount > 1) {
            errorMsgs.add("Only one variable should contain "+ EMPTY + " value");
            System.out.println("Only one variable should contain "+ EMPTY + " value");
        }

//        return errorMsgs;
//        FinanceCalculatorRequest financeCalculatorRequest = new FinanceCalculatorRequest(Double.parseDouble(rawLoanAmount),
//                Double.parseDouble(rawPaymentAmount), Float.valueOf(rawAnnualInterestRate), Integer.valueOf(rawNumberOfPayments),
//                calculateAttribute);
        return financeCalculatorRequest;
    }


    private double convertToDouble(String value) {
        double doubleValue = 0.00;
        NumberFormat format = NumberFormat.getInstance(Locale.US);
        try {
            Number number = format.parse(value.replaceAll("$", ""));
            doubleValue = number.doubleValue();
        } catch (ParseException pe) {
            errorMsgs.add("Error Converting "+value);
            System.err.println("Error converting to double: " +pe);
        }
        return doubleValue;
    }

    private int convertToInt(String value) {
        int intValue = 0;
        NumberFormat format = NumberFormat.getInstance(Locale.US);
        try {
            Number number = format.parse(value);
            intValue = number.intValue();
        } catch (ParseException pe) {
            errorMsgs.add("Error Converting "+value);
            System.err.println("Error converting to int: " +pe);
        }
        return intValue;
    }
}
