package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("지난주 당첨 로또 테스트")
class WinningLottoTest {

    private static Stream<Arguments> winningLottoProvider(){
        return Stream.of(
                Arguments.of("1,2,3,4,5,6",8),
                Arguments.of("1,2,3,4,5,6",9),
                Arguments.of("1,2,3,4,5,6",10)
        );
    }

    @DisplayName("당첨 로또,보너스 번호를 입력받아 객체를 생성한다.")
    @ParameterizedTest
    @MethodSource(value = "winningLottoProvider")
    void of(String inputNumbers,int bonusNumber) {
        WinningLotto winningLotto = WinningLotto.of(inputNumbers,bonusNumber);
        assertNotNull(winningLotto);
    }

    private static Stream<Arguments> inValidBonusNumberProvider(){
        return Stream.of(
                Arguments.of("1,2,3,4,5,6",6),
                Arguments.of("1,2,3,4,5,6",-9),
                Arguments.of("1,2,3,4,5,6",80)
        );
    }

    @DisplayName("보너스볼이 이미 포함되어있거나 로또 숫자 범위를 벗어나면 익셉션이 발생한다.")
    @ParameterizedTest
    @MethodSource(value = "inValidBonusNumberProvider")
    void 보너스볼_유효성_검증(String inputNumbers,int bonusNumber){
        assertThrows(IllegalArgumentException.class,() ->
            WinningLotto.of(inputNumbers,bonusNumber)
        );

    }

}
