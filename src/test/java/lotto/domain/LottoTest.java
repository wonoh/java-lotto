package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("로또 도메인테스트")
class LottoTest {

    private static Stream<Arguments> lottoProvider(){
        return Stream.of(
                Arguments.of(Stream.of(2,32,14,6,23,7)
                        .map(LottoNumber::of)
                        .collect(Collectors.toList())),
                Arguments.of(Stream.of(2,1,5,8,15,7)
                        .map(LottoNumber::of)
                        .collect(Collectors.toList())),
                Arguments.of(Stream.of(1,32,16,23,20,21)
                        .map(LottoNumber::of)
                        .collect(Collectors.toList()))
        );
    }

    @DisplayName("LottoNumber 로 Lotto 도메인을 생성한다.")
    @MethodSource(value = "lottoProvider")
    @ParameterizedTest
    void Lotto_of(List<LottoNumber> numbers) {
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
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        Lotto lotto = Lotto.of(lottoNumbers);
        assertNotNull(lotto);
    }
}
