package lotto.domain;

import static lotto.domain.constant.LottoConstants.*;

public class WinningLotto {

    private Lotto lotto;
    private int bonusNumber;

    private WinningLotto(Lotto lotto,int bonusNumber){
        this.lotto = lotto;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }
    public static WinningLotto of(String inputNumbers,int bonusNumber){
        return new WinningLotto(
                Lotto.of(inputNumbers),
                bonusNumber
        );
    }
    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public Lotto lotto() {
        return lotto;
    }
    private void validateBonusNumber(Integer bonusNumber){
        if(this.lotto.contains(bonusNumber)){
            throw new IllegalArgumentException(bonusNumber+"는 중복된 번호입니다.");
        }
        if(bonusNumber <= LOTTO_START_NUMBER || bonusNumber >= LOTTO_END_NUMBER){
            throw new IllegalArgumentException(bonusNumber+"는 로또 숫자 범위에서 벗어납니다.");
        }

    }
}
