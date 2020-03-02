package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("로또 저장소 테스트")
class LottoStoreTest {


    @DisplayName("생성된 로또들로 로또 저장소를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6","3,5,6,7,8,9"})
    void of(String inputNumbers) {
        LottoStore lottoStore = createLottoStore(inputNumbers);
        assertNotNull(lottoStore);
    }
    private static Stream<Arguments> winningLottoProvider(){
        return Stream.of(
                Arguments.of("1,2,3,4,5,6",8),
                Arguments.of("1,2,3,4,5,6",9),
                Arguments.of("1,2,3,4,5,6",10)
        );
    }

    @DisplayName("지난주 당첨로또로 결과를 생성한다.")
    @ParameterizedTest
    @MethodSource(value = "winningLottoProvider")
    void createResults(String inputNumbers,int bonusNumber) {
        LottoStore lottoStore = createLottoStore(inputNumbers);
        WinningLotto winningLotto = WinningLotto.of(inputNumbers,bonusNumber);
        Results results = lottoStore.createResults(winningLotto);
        assertNotNull(results);
    }
    public static LottoStore createLottoStore(String inputNumbers){
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.of(inputNumbers));
        return LottoStore.of(lottos,new ArrayList<>());
    }

}
