package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("지난주 당첨 로또 테스트")
class WinningLottoTest {

    @DisplayName("당첨 로또를 입력받아 객체를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6","3,5,6,7,8,9"})
    void of(String inputNumbers) {
        WinningLotto winningLotto = WinningLotto.of(inputNumbers);
        assertNotNull(winningLotto);
    }


}
