package priv.noby.maven;

public class MathUtil {
    public static int addition(int... i) {
        int result = 0;
        for (int i1 : i) {
            result += i1;
        }
        return result;
    }
}
