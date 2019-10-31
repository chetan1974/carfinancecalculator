package edu.stthomas.carfinance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for FinanceCalculator
 */
public class FinanceCalculatorTest {
    FinanceCalculator financeCalculator;

    @Before
    public void setup(){
        financeCalculator = new FinanceCalculator();
    }

    @Test
    public void loanAmount() {
        double loanAmount = financeCalculator.calculate(48,4.5f,741.26);
        assertEquals(32500f,loanAmount,10f);
    }

    @Test
    public void testPaymentAmount() {
        double paymentAmount = financeCalculator.calculate(32500.0, 48, 4.5f);
        assertEquals(741.11,paymentAmount,0.1f);
    }

    @Test
    public void numberOfMonthlyPayment() {
        int numberOfPayments = financeCalculator.calculate(32500.0, 4.5f, 741.11);
        assertEquals(48,numberOfPayments);
    }

    @Test
    public void intRate() {
        float apr = financeCalculator.calculate(32500.0, 48, 741.26);
        assertEquals(4.5,apr,0.1f);
    }


    @Test
    public void intRateLowInt() {
        float apr = financeCalculator.calculate(32500.0, 48, 684.02);
        assertEquals(0.5,apr,0.1f);
    }

    /**
     * Difference of calculated and actual payment is always greater than 1. Higher loan amounts.
     */
    @Test
    public void intRateHigherAmount() {
        float apr = financeCalculator.calculate(9999999.0, 72, 153_282.500);
        assertEquals(3.3,apr,0.1f);
    }

}
