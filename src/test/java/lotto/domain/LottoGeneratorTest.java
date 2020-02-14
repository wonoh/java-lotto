package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("로또 생성기 테스트")
class LottoGeneratorTest {

    @DisplayName("금액만큼 로또를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1000,2000,3000,5000})
    void 금액만큼_로또_생성(int inputMoney){
        Money money = Money.of(inputMoney);
        LottoStore lottoStore = LottoGenerator.generateLottoStore(money);

        int expectedCount = money.lottoCount();
        assertEquals(expectedCount,lottoStore.getLottos().size());
    }
    @DisplayName("생성된 로또는 6개의 리스트이다.")
    @ParameterizedTest
    @ValueSource(ints = {1000,2000,3000,5000})
    void 로또_숫자개수_6개(int inputMoney){
        Money money = Money.of(inputMoney);
        LottoStore lottoStore = LottoGenerator.generateLottoStore(money);

        int expectedCount = 6;
        for (Lotto lotto : lottoStore.getLottos()) {
            assertEquals(expectedCount,lotto.getNumbers().size());
        }
    }

}
