package Cinema;

import java.util.HashMap;
import java.util.Map;

public class DiscountCode {
    private static final Map<String, Double> DISCOUNT_CODES = new HashMap<>();

    static {
        DISCOUNT_CODES.put("AEH", 0.6);
    }

    public static double applyDiscount(String discountCode, double ticketPrice) {
        if (DISCOUNT_CODES.containsKey(discountCode)) {
            return ticketPrice * DISCOUNT_CODES.get(discountCode);
        } else {
            return ticketPrice;
        }
    }
}
