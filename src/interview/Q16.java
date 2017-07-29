package interview;

/**
 * Created by GuoWeiyu on 2017/07/27.
 * Description:
 */
public class Q16 {
    public static void main(String[] args) {
        double base=2;
        int exponent=-2;
        System.out.println(pow(base,exponent));
    }

    private static double pow(double base, int exponent) {
        if (base == 0 && exponent == 0) {
            return 0;
        }
        double result = internalPow(base, Math.abs(exponent));
        if (exponent < 0) {     //指数为负，需求其倒数
            result = 1.0 / result;
        }
        return result;
    }

    /**
     * 针对exponent非负
     */
    private static double internalPow(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = internalPow(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) {    //odd
            result *= base;
        }
        return result;
    }
}
