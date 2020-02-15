package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    @DisplayName("당첨번호를 입력받으면 문자열 분리하여 Lotto 도메인을 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = "1, 2, 3, 4, 5, 6")
    void Lotto_of(String inputNumbers){
        String[] split = inputNumbers.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String s : split) {
            numbers.add(Integer.parseInt(s.trim()));
        }
        Lotto lotto = Lotto.of(numbers);
        assertNotNull(lotto);
    }
}
