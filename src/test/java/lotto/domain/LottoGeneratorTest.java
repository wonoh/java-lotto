package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("로또 생성기 테스트")
class LottoGeneratorTest {

    @DisplayName("금액만큼 로또를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1000,2000,3000,5000})
    void 금액만큼_로또_생성(int inputMoney){
        Money money = Money.of(inputMoney);
        LottoStore lottoStore = LottoGenerator.generateLottoStore(money,Collections.emptyList());

        int expectedCount = money.lottoCount();
        assertEquals(expectedCount,lottoStore.getLottos().size());
    }
    @DisplayName("생성된 로또는 6개의 리스트이다.")
    @ParameterizedTest
    @ValueSource(ints = {1000,2000,3000,5000})
    void 로또_숫자개수_6개(int inputMoney){
        Money money = Money.of(inputMoney);
        LottoStore lottoStore = LottoGenerator.generateLottoStore(money,Collections.emptyList());

        int expectedCount = 6;
        for (Lotto lotto : lottoStore.getLottos()) {
            assertEquals(expectedCount,lotto.getNumbers().size());
        }
    }
    private static Stream<Arguments> moneyAndLottoProvider(){
        return Stream.of(
                Arguments.of(1000, Arrays.asList("1,2,3,4,5,6","10,20,30,40,24,5")),
                Arguments.of(2000,Arrays.asList("1,2,3,4,5,6","10,20,30,40,24,5")),
                Arguments.of(3000, Collections.singletonList("1,2,3,4,5,6"))
        );
    }
    @DisplayName("수동과 자동을 구분하여 로또를 생성한다.")
    @ParameterizedTest
    @MethodSource(value = "moneyAndLottoProvider")
    void 수동_자동_로또발급(int inputMoney, List<String> inputManualLottos){
        Money money =  Money.of(inputMoney);
        LottoStore lottoStore = LottoGenerator.generateLottoStore(money,inputManualLottos);
        int manualLottoSize = inputManualLottos.size();
        assertThat(lottoStore).isNotNull();
        assertThat(lottoStore.getManualLottoCount()).isEqualTo(manualLottoSize);
    }

}
