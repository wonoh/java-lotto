package global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("랜덤 유틸 테스트")
class RandomUtilTest {

    @DisplayName("새로운 랜덤 객체를 생성한다.")
    @Test
    void 새로운_랜덤_객체_생성(){
        final Random random = RandomUtil.random();
        assertNotNull(random);
    }

}