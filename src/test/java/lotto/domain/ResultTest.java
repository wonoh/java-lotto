package lotto.domain;

import lotto.domain.type.ResultType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Result 테스트")
class ResultTest {

    @DisplayName("결과타입을 받아 객체를 생성한다.")
    @Test
    void of() {
        Result result = Result.of(ResultType.SIX);
        assertNotNull(result);
    }
}
