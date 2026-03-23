import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    @Test
    public void shouldCalculateTotalPrice() {
        ShoppingCart.setSum(0);

        ShoppingCart.calculateTotalPrice(12.00, 3);
        assertEquals(36.00, ShoppingCart.getSum(), 0.01);
        ShoppingCart.calculateTotalPrice(1.01, 4);
        assertEquals(40.04, ShoppingCart.getSum(), 0.01);
    }

    @Test
    public void shouldCalculateNegativeTotalPrice() {
        ShoppingCart.setSum(0);

        ShoppingCart.calculateTotalPrice(-11.50, 1);
        assertEquals(-11.50, ShoppingCart.getSum());
        ShoppingCart.calculateTotalPrice(-2.00, 4);
        assertEquals(-19.50, ShoppingCart.getSum(), 0.01);
    }

    @Test
    public void shouldCalculateZeroTotalPrice() {
        ShoppingCart.setSum(0);

        ShoppingCart.calculateTotalPrice(-11.50, 0);
        assertEquals(0, ShoppingCart.getSum());
        ShoppingCart.calculateTotalPrice(42.55, 0);
        assertEquals(0, ShoppingCart.getSum());
    }

}
