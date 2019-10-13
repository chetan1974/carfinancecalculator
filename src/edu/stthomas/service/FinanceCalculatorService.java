package edu.stthomas.service;

import edu.stthomas.carfinance.FinanceCalculator;
import edu.stthomas.model.FinanceCalculatorRequest;
import edu.stthomas.model.FinanceCalculatorResponse;
import edu.stthomas.model.RawInput;
import edu.stthomas.util.ValidationService;

public class FinanceCalculatorService {
    RawInput rawInput;
    FinanceCalculator financeCalculator = new FinanceCalculator();

    public FinanceCalculatorService(RawInput rawInput) {
        this.rawInput = rawInput;
    }

    public FinanceCalculatorResponse process() {

        FinanceCalculatorResponse financeCalculatorResponse = new FinanceCalculatorResponse();
        //validate inputs.
        ValidationService requestValidator = new ValidationService();
        FinanceCalculatorRequest financeCalculatorRequest = requestValidator.validate(rawInput);

        switch (financeCalculatorRequest.getCalculateAttribute()) {
            case LOAN_AMOUNT:
                double loanAmount = financeCalculator.calculate(financeCalculatorRequest.getNumberOFPayments(), financeCalculatorRequest.getAnnualInterestRate(),
                        financeCalculatorRequest.getPaymentAmount());
                System.out.println("loan amount is: " +loanAmount);
                break;
            case NUMBER_OF_PAYMENTS:
                int numberOfPayments = financeCalculator.calculate(financeCalculatorRequest.getLoanAmount(), financeCalculatorRequest.getAnnualInterestRate(),
                        financeCalculatorRequest.getPaymentAmount());
                System.out.println("loan number of payments are: " +numberOfPayments);
                break;
            case ANNUAL_INTEREST_RATE:
                float annualInterestRate = financeCalculator.calculate(financeCalculatorRequest.getLoanAmount(), financeCalculatorRequest.getNumberOFPayments(),
                        financeCalculatorRequest.getPaymentAmount());
                System.out.println("loan annual interest rate are: " +annualInterestRate);
                break;
            case PAYMENT_AMOUNT:
                double paymentAmount  = financeCalculator.calculate(financeCalculatorRequest.getLoanAmount(), financeCalculatorRequest.getNumberOFPayments(),
                        financeCalculatorRequest.getAnnualInterestRate());
                System.out.println("loan payment amount is: " +paymentAmount);
                break;
            default:
                System.err.println("No attribute to calculate.");
                break;
        }

        return  financeCalculatorResponse;
    }
}
