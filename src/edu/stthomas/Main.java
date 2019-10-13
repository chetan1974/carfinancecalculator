package edu.stthomas;

import edu.stthomas.model.RawInput;
import edu.stthomas.service.FinanceCalculatorService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter loan amount");

        String loanAmount = myObj.nextLine();  // Read user input
//        System.out.println("Enter loan amount is: " + loanAmount);  // Output user input

        System.out.println("Enter payment amount");
        String paymentAmount = myObj.nextLine();  // Read user input
//        System.out.println("Enter payment amount is: " + paymentAmount);  // Output user input

        System.out.println("Annual interest rate");  // Output user input
        String annualInterestRate = myObj.nextLine();  // Read user input

        System.out.println("Enter number of payment");  // Output user input
        String numberOfPayments = myObj.nextLine();  // Read user input

        RawInput rawInput = new RawInput(loanAmount, paymentAmount, annualInterestRate, numberOfPayments);
        //call the service to return response to convey client
        FinanceCalculatorService service = new FinanceCalculatorService(rawInput);
        service.process();
    }
}
