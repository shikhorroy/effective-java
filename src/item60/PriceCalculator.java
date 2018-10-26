package item60;

import java.math.BigDecimal;

/**
 * Item 60: Avoid float and double if exact answer is required
 */
public class PriceCalculator {
    void usingPrimitives() {
        System.out.println("--- USING PRIMITIVES TYPE ---");
        double funds = 1.0;
        int itemBought = 0;
        for (double price = 0.10; funds >= price; price += 0.10) {
            funds -= price;
            itemBought++;
        }
        System.out.println("Items bought: " + itemBought);
        System.out.println("Changes: " + funds);
        System.out.println();
    }

    void usingBigDecimal() {
        System.out.println("--- USING BigDecimal ---");
        final BigDecimal TEN_CENTS = new BigDecimal("0.10");
        BigDecimal funds = new BigDecimal("1.0");
        int itemBought = 0;
        for (BigDecimal price = TEN_CENTS; funds.compareTo(price) >= 0; price = price.add(TEN_CENTS)) {
            funds = funds.subtract(price);
            itemBought++;
        }
        System.out.println("Items bought: " + itemBought);
        System.out.println("Changes: " + funds);
    }

    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator();
        calculator.usingPrimitives();
        calculator.usingBigDecimal();
    }
}
