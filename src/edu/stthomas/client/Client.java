package edu.stthomas.client;

import edu.stthomas.carfinance.FinanceCalculator;
import edu.stthomas.enums.Attributes;
import edu.stthomas.model.Records;

import java.util.Scanner;

public class Client {
    static Records records = new Records();

    public static void start() {
        System.out.println(initialScreen());
        Scanner myObj = new Scanner(System.in);
        try {
            FinanceCalculator financeCalculator = new FinanceCalculator();
            String choice = myObj.nextLine();  // Read user input
            switch (choice) {
                case "1": //calculate monthly amount
                    float intRate = getAnnIntRate(myObj);
                    int numOfMonths = getMonths(myObj);
                    double principalAmt = getPrincipal(myObj);
                    double monthlyAmt = financeCalculator.calculate(principalAmt, numOfMonths, intRate);
                    System.out.println("Loan payment amount is: " + monthlyAmt);
                    records.add(Attributes.MONTHLY_AMT, principalAmt, monthlyAmt, intRate, numOfMonths);
                    break;

                case "2": //calculate Int Rate
                    monthlyAmt = getPaymentAmount(myObj);
                    numOfMonths = getMonths(myObj);
                    principalAmt = getPrincipal(myObj);
                    intRate = financeCalculator.calculate(principalAmt, numOfMonths, monthlyAmt);
                    System.out.println("Interest rate is: " + intRate);
                    records.add(Attributes.ANNUAL_RATE, principalAmt, monthlyAmt, intRate, numOfMonths);
                    break;

                case "3": //calculate Number of Months
                    principalAmt = getPrincipal(myObj);
                    monthlyAmt = getPaymentAmount(myObj);
                    intRate = getAnnIntRate(myObj);
                    numOfMonths = financeCalculator.calculate(principalAmt, intRate, monthlyAmt);
                    System.out.println("Number of months: " + numOfMonths);
                    records.add(Attributes.NUM_OF_MTHS, principalAmt, monthlyAmt, intRate, numOfMonths);
                    break;

                case "4": //calculate principal amount
                    monthlyAmt = getPaymentAmount(myObj);
                    intRate = getAnnIntRate(myObj);
                    numOfMonths = getMonths(myObj);
                    principalAmt = financeCalculator.calculate(numOfMonths, intRate, monthlyAmt);
                    System.out.println("Principal amount: " + principalAmt);
                    records.add(Attributes.LOAN_AMOUNT, principalAmt, monthlyAmt, intRate, numOfMonths);
                    break;

                case "5":
                    System.out.println(records);
                    break;

                case "X":
                    System.out.println("Good bye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please enter one of the given options");
                    start();
                    break;
            }
        }catch (NumberFormatException nfe) {
            System.out.println(nfe.getMessage());
        }
        System.out.println("");
        //repeat until option X is selected
        start();
    }

    private static float getAnnIntRate(Scanner myObj) {
        System.out.println("Enter Annual Int Rate");
        Float annIntRate = 0.0f;
        try {
            annIntRate = myObj.nextFloat();
        }catch (Exception e) {
            throw new NumberFormatException("For Annual Int Rate, please enter a numeric value like: 1 or 1.00.");
        }
        return annIntRate;
    }

    /**
     * @param myObj
     * @return
     */
    private static int getMonths(Scanner myObj) {
        System.out.println("Enter Number of months");
        int months = 0;
        try {
            months = myObj.nextInt();
            if((2 > months) || (months > 72)) {
                throw new NumberFormatException("number of payments should be in range of 2 to 72");
            }
        }catch (Exception e) {
            throw new NumberFormatException("For months, please enter a numeric value like: 1 with no decimals in the range of 2 and upto 72.");
        }
        return months;
    }

    private static double getPrincipal(Scanner myObj) {
        System.out.println("Enter principal amount");
        double principal = 0;
        try {
            principal = myObj.nextDouble();
        }catch (Exception e) {
            throw new NumberFormatException("For principal amount, please enter a numeric value like: 1 or 1.00.");
        }
        return principal;
    }

    private static double getPaymentAmount(Scanner myObj) {
        System.out.println("Enter payment amount");
        double paymentAmount = 0;
        try {
            paymentAmount = myObj.nextDouble();
        }catch (Exception e) {
            throw new NumberFormatException("For payment amount, please enter a numeric value like: 1 or 1.00.");
        }
        return paymentAmount;
    }

    private static String initialScreen() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Please select one of the following options\n");
        stringBuilder.append("1\tCalculate Monthly Amount\n");
        stringBuilder.append("2\tCalculate Ann Int. Rate\n");
        stringBuilder.append("3\tCalculate Number of Months\n");
        stringBuilder.append("4\tCalculate Principal Amount\n");
        stringBuilder.append("5\tPrint All Saved Results\n");
        stringBuilder.append("X\tTo Exit the Application\n");
        stringBuilder.append(" \tSelection:\n");

        return stringBuilder.toString();
    }
}
