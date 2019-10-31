package edu.stthomas.model;

import edu.stthomas.enums.Attributes;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Data class to hold records.
 */
public class Records {
    private List<Record> records = new ArrayList<>();

    public void add(Attributes attribute, double principalAmt, double monthlyAmt, float intRate, int numOfMonths) {
        records.add(new Record(attribute, principalAmt, monthlyAmt, intRate, numOfMonths));
    }


    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("###.##");
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%1$-13s %2$-13s %3$-13s %4$-13s %5$-13s", "Calculate", "Principal", "IntRate", "Months", "Monthly amount")).append("\n");
        for(Record record: records) {
            String attribute = record.getCalculatedAttribute().toString();
            String principal = df.format(record.getLoanAmount());
            String intRate = df.format(record.getAnnualInterestRate());
            String paymentAmt = df.format(record.getPaymentAmount());

            builder.append(String.format("%1$-13s %2$-13s %3$-13s %4$-13d %5$-13s", attribute, principal, intRate, record.getNumberOfPayments(), paymentAmt));
            builder.append("\n");
        }
        builder.append("\n");
        return builder.toString();
    }

}
