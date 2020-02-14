package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로또 도메인테스트")
class LottoTest {

    private static Stream<Arguments> lottoProvider(){
        return Stream.of(
                Arguments.of(Arrays.asList(2,32,14,6,23,7)),
                Arguments.of(Arrays.asList(5,4,20,32,19,13)),
                Arguments.of(Arrays.asList(2,32,14,6,23,1))
        );
    }

    @DisplayName("6개의 숫자가 담긴 리스트로 Lotto 도메인을 생성한다.")
    @MethodSource(value = "lottoProvider")
    @ParameterizedTest
    void Lotto_of(List<Integer> numbers) {
        Lotto lotto = Lotto.of(numbers);
        assertNotNull(lotto);
        assertEquals(numbers,lotto.getNumbers());
    }
}
