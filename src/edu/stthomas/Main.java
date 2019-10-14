package edu.stthomas;

import edu.stthomas.carfinance.FinanceCalculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        Scanner myObj = new Scanner(System.in);
        try {
            System.out.println(initialScreen());
            FinanceCalculator financeCalculator = new FinanceCalculator();

            String choice = myObj.nextLine();  // Read user input
            switch (choice) {
                case "1": //calculate monthly amount
                    float apr = getApr(myObj);
                    int numOfMonths = getMonths(myObj);
                    double principalAmt = getPrincipal(myObj);
                    double monthlyAmt = financeCalculator.calculate(principalAmt, numOfMonths, apr);
                    System.out.println("loan payment amount is: " + monthlyAmt);
                    break;

                case "2": //calculate APR
                    monthlyAmt = getPaymentAmount(myObj);
                    numOfMonths = getMonths(myObj);
                    principalAmt = getPrincipal(myObj);
                    apr = financeCalculator.calculate(principalAmt, numOfMonths, monthlyAmt);
                    System.out.println("APR is: " + apr);
                    break;

                case "3": //calculate Number of Months
                    principalAmt = getPrincipal(myObj);
                    monthlyAmt = getPaymentAmount(myObj);
                    apr = getApr(myObj);
                    numOfMonths = financeCalculator.calculate(principalAmt, apr, monthlyAmt);
                    System.out.println("Number of months: " + numOfMonths);
                    break;

                case "4": //calculate principal amount
                    monthlyAmt = getPaymentAmount(myObj);
                    apr = getApr(myObj);
                    numOfMonths = getMonths(myObj);
                    principalAmt = financeCalculator.calculate(numOfMonths, apr, monthlyAmt);
                    System.out.println("Principal amount: " + principalAmt);
                    break;

                case "5":
                    System.out.println(financeCalculator.toString());
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
        //repeat until option X is selected
        start();
    }

    private static float getApr(Scanner myObj) {
        System.out.println("Enter APR");
        Float apr = 0.0f;
        try {
            apr = myObj.nextFloat();
        }catch (Exception e) {
            throw new NumberFormatException("For APR, please enter a numeric value like: 1 or 1.00.");
        }
        return apr;
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
        stringBuilder.append("2\tCalculate APR\n");
        stringBuilder.append("3\tCalculate Number of Months\n");
        stringBuilder.append("4\tCalculate Principal Amount\n");
        stringBuilder.append("5\tPrint All Saved Results\n");
        stringBuilder.append("X\tTo Exit the Application\n");
        stringBuilder.append(" \tSelection:\n");

        return stringBuilder.toString();
    }
}
