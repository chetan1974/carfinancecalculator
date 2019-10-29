package edu.stthomas.carfinance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FinanceCalculatorTest {
    FinanceCalculator financeCalculator;

    @Before
    public void setup(){
        financeCalculator = new FinanceCalculator();
    }

    @Test
    public void testLoanAmount() {
        double loanAmount = financeCalculator.calculate(48,4.5f,741.26);
        assertEquals(32500f,loanAmount,10f);
    }

    @Test
    public void testAPR() {
        float apr = financeCalculator.calculate(32500.0, 48, 741.26);
        assertEquals(4.5,apr,0.1f);
    }

    @Test
    public void testPaymentAmount() {
        double paymentAmount = financeCalculator.calculate(32500.0, 48, 4.5f);
        assertEquals(741.11,paymentAmount,0.1f);
    }

    @Test
    public void testPaymentMonths() {
        int numberOfPayments = financeCalculator.calculate(32500.0, 4.5f, 741.11);
        assertEquals(48,numberOfPayments);
    }

}
