package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("돈 도메인 테스트")
class MoneyTest {

    @DisplayName("입력금액으로 돈 객체를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {100,200,300})
    void Money_of(int inputMoney) {
        Money money = Money.of(inputMoney);
        assertNotNull(money);
    }
    @DisplayName("로또 저장소로 로또입력금액을 계산하여 돈 객체를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6","3,5,6,7,8,9"})
    void Money_of(String inputNumbers) {
        Lotto lotto = Lotto.of(inputNumbers);
        LottoStore lottoStore = LottoStore.of(Collections.singletonList(lotto));
        Money money = Money.of(lottoStore);
        assertNotNull(money);
        assertEquals(1000,money.getMoney());
        assertEquals(1,money.lottoCount());
    }

    @DisplayName("금액으로 로또를 몇개를 살 수 있나 계산한다.")
    @ParameterizedTest
    @ValueSource(ints = {1000,2002,3000})
    void lottoCount(int inputMoney) {
        Money money = Money.of(inputMoney);
        int lottoPrice = 1000;
        int expectedSize = inputMoney / lottoPrice;
        assertEquals(expectedSize,money.lottoCount());
    }

}
