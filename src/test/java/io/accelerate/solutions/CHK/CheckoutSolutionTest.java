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

        assertThat(result, equalTo(180));
    }

    @Test
    void testCheckout2(){
        String skus = "AAABBC";
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout(skus);

        assertThat(result, equalTo(195));
    }

    @Test
    void testCheckout_null(){
        String skus = null;
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout(skus);

        assertThat(result, equalTo(-1));
    }
}


