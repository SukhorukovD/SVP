package stubClasses;

public class Math {

    private static final int Count = 10_000;
    public static Double getModRow(double a) {
        double result = 0;
        for (int i = 1; i < a; i++) {
            result += a % i / Count;
        }
        return result;
    }
}