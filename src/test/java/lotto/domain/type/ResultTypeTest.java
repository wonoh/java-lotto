package lotto.domain.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("결과 타입 테스트")
class ResultTypeTest {

    private static Stream<Arguments> prizeProvider(){
        return Stream.of(
                Arguments.of(3,2000,6000),
                Arguments.of(2,2000,4000),
                Arguments.of(3,5000,15000)
        );
    }

    @DisplayName("로또매치갯수 * 해당 타입의상금 을 리턴한다.")
    @ParameterizedTest
    @MethodSource(value = "prizeProvider")
    void prize(int lottoMatchCount,int price,int expected) {
        assertEquals(expected,lottoMatchCount*price);
    }

    @DisplayName("매치갯수로 타입을 찾는다.")
    @ParameterizedTest
    @ValueSource(ints = {3,4,5})
    void findType(int matchCount) {
        ResultType resultType = Arrays.stream(ResultType.values())
                .filter(r -> r.hasCount(matchCount))
                .findFirst()
                .orElse(ResultType.SORRY);
        assertNotNull(resultType);
    }

}
