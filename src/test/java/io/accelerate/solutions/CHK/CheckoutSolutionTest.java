package io.accelerate.solutions.CHK;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSolutionTest
{
    @Test
    void testCheckout(){
        String skus = "AAABC";
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout(skus);

        assertThat(result, equalTo(160));
    }
}


