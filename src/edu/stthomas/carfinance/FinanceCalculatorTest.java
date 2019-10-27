package edu.stthomas.carfinance;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FinanceCalculatorTest {
    FinanceCalculator financeCalculator;

    @Before
    public void setup(){
        financeCalculator = new FinanceCalculator();

    }

    @Test
    public void testLoanAmount() {
        double loanAmount = financeCalculator.calculate(48,4.5f,741.26);
        Assert.assertEquals(32500f,loanAmount,10f);
    }

    @Test
    public void testAPR() {
        float apr = financeCalculator.calculate(32500.0, 48, 741.26);
        Assert.assertEquals(4.5,apr,0.5f);
    }

    @Test
    public void testPaymentAmount() {
        double paymentAmount = financeCalculator.calculate(32500.0, 48, 4.5f);
        Assert.assertEquals(741.26,paymentAmount,0.5f);
    }

}
