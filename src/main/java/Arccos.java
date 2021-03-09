import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Double.NaN;
import static java.lang.Math.pow;

public class Arccos {

    public static double arccos(double val) {
        if (val > 1 || val < -1) {
            throw new IllegalArgumentException();
        }
        double result = Math.PI / 2;
        for (int n = 0; n < 10; n++) {
            double num = pow(val, 2 * n + 1) * factorial(2 * n) /
                    (pow(4, n) * pow(factorial(n), 2) * (2 * n + 1));
            result -= num;
        }
        return round(result, 2);
    }

    private static int factorial(int val) {
        if (val <= 1)
            return 1;
        else
            return val * (factorial(val - 1));
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
