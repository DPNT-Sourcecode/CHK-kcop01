package io.accelerate.solutions.CHK;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSolutionTest
{
    @Test
    void testCheckout10H(){
        String skus = "HHHHHHHHHH";
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout(skus);

        assertThat(result, equalTo(80));
    }
    @Test
    void testCheckout11H(){
        String skus = "HHHHHHHHHHH";
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout(skus);

        assertThat(result, equalTo(90));
    }
    @Test
    void testCheckout3U(){
        String skus = "UUU";
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout(skus);

        assertThat(result, equalTo(120));
    }
    @Test
    void testCheckout2F(){
        String skus = "FF";
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout(skus);

        assertThat(result, equalTo(20));
    }
    @Test
    void testCheckout4F(){
        String skus = "FFFF";
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout(skus);

        assertThat(result, equalTo(30));
    }
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
    void testCheckoutOffers5A(){
        String skus = "AAAAA";
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout(skus);

        assertThat(result, equalTo(200));
    }
    @Test
    void testCheckoutOffers6A(){
        String skus = "AAAAAA";
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout(skus);

        assertThat(result, equalTo(250));
    }
    @Test
    void testCheckoutOffers7A(){
        String skus = "AAAAAAA";
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout(skus);

        assertThat(result, equalTo(300));
    }
    @Test
    void testCheckoutOffers4(){
        String skus = "ABCDCBAABCABBAAA";
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout(skus);

        assertThat(result, equalTo(495));
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
        @Test
        void testCheckoutOffer3F(){
            String skus = "FFF";
            CheckoutSolution checkoutSolution = new CheckoutSolution();
            int result = checkoutSolution.checkout(skus);

            assertThat(result, equalTo(20));
        }
        @Test
        void testCheckoutOffer6F(){
            String skus = "FFFFFF";
            CheckoutSolution checkoutSolution = new CheckoutSolution();
            int result = checkoutSolution.checkout(skus);

            assertThat(result, equalTo(40));
        }
        @Test
        void testCheckoutOffer2F(){
            String skus = "ABFF";
            CheckoutSolution checkoutSolution = new CheckoutSolution();
            int result = checkoutSolution.checkout(skus);

            assertThat(result, equalTo(100));
        }
}
