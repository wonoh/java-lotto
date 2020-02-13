package global;

import java.util.Random;

public final class RandomUtil {
    private RandomUtil() {
    }
    public static Random random(){
        return new Random(System.currentTimeMillis());
    }
}
