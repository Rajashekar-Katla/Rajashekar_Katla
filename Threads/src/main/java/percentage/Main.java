package percentage;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: Rajashekar
 * Date: 12/07/14
 * Time: 19:25
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    private static final BigDecimal BIG_DECIMAL = new BigDecimal("100");

    public static void main(String[] args) {
        final BigDecimal value = new BigDecimal("120");
        final BigDecimal percent = new BigDecimal("10");
        final BigDecimal out = value.subtract(value.multiply(percent.divide(BIG_DECIMAL))).setScale(2);
        System.out.println(out);

    }
}
