package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Results 테스트")
class ResultsTest {

    @DisplayName("로또 저장소를 받아 객체를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6","3,5,6,7,8,9"})
    void of(String inputNumbers) {
        LottoStore lottoStore = LottoStoreTest.createLottoStore(inputNumbers);
        Results results = Results.of(lottoStore);
        assertNotNull(results);
    }

    private static Stream<Arguments> yieldProvider(){
        return Stream.of(
                Arguments.of(14000,5000,35.0)
        );
    }

    @DisplayName("수익률을 계산한다.")
    @ParameterizedTest
    @MethodSource(value = "yieldProvider")
    void getYield(int lottoInputMoney,int winningInputMoney,double yield) {
        Money lottoMoney = Money.of(lottoInputMoney);
        Money winningMoney = Money.of(winningInputMoney);
        assertEquals(yield,lottoMoney.yield(winningMoney));
    }

}
