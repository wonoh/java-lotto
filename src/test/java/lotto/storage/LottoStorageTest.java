package lotto.storage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로또 저장소 테스트")
class LottoStorageTest {

    @DisplayName("LottoStorage 클래스가 로딩되면 가격,로또숫자가 1~45까지 생성된다.")
    @Test
    void LottoStorage_클래스로딩_가격_로또숫자_1_45_생성(){
        assertNotNull(LottoStorage.lottoNumbers);
        int expectedSize = 45;
        int expectedPrice = 1000;
        assertEquals(expectedSize,LottoStorage.lottoNumbers.size());
        assertEquals(expectedPrice,LottoStorage.PRICE);
    }

}