package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("로또 숫자 테스트")
class LottoNumberTest {

    @DisplayName("로또 숫자 객체를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    void of(int number) {
        LottoNumber lottoNumber = LottoNumber.of(number);
        assertThat(lottoNumber).isNotNull();
    }
    @DisplayName("로또 숫자 범위가 벗어나면 익셉션이 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1,-2,50})
    void 로또범위_벗어나면_익셉션(int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() ->LottoNumber.of(number));
    }
}