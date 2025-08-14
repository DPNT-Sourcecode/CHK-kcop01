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
    void testCheckoutOffers(){
        String skus = "AAAA";
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout(skus);

        assertThat(result, equalTo(180));
    }
    @Test
    void testCheckoutOffers3(){
        String skus = "AAAAA";
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout(skus);

        assertThat(result, equalTo(200));
    }
    @Test
    void testCheckoutOffers2(){
        String skus = "AAAAAA";
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout(skus);

        assertThat(result, equalTo(260));
    }
    @Test
    void testCheckoutOffers4(){
        String skus = "ABCDCBAABCABBAAA";
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout(skus);

        assertThat(result, equalTo(505));
    }
    @Test
    void testCheckoutOffers5(){
        String skus = "BABDDCAC";
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout(skus);

        assertThat(result, equalTo(215));
    }

    @Test
    void testCheckout2(){
        String skus = "";
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout(skus);
        assertThat(result, equalTo(0));
    }
    @Test
    void testCheckout3(){
        String skus = "a";
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout(skus);
        assertThat(result, equalTo(-1));
    }
    @Test
    void testCheckout4(){
        String skus = "-";
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout(skus);
        assertThat(result, equalTo(-1));
    }

    @Test
    void testCheckout_null() {
        String skus = null;
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout(skus);

        assertThat(result, equalTo(-1));
    }
        @Test
        void testCheckoutOfferE(){
            String skus = "ABBEE";
            CheckoutSolution checkoutSolution = new CheckoutSolution();
            int result = checkoutSolution.checkout(skus);

            assertThat(result, equalTo(160));
        }
}

