package lotto.domain;

public class WinningLotto {

    private Lotto lotto;
    private Integer bonusNumber;

    private WinningLotto(Lotto lotto,Integer bonusNumber){
        this.lotto = lotto;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }
    public static WinningLotto of(String inputNumbers,String bonusNumber){
        return new WinningLotto(
                Lotto.of(inputNumbers),
                Integer.valueOf(bonusNumber)
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
            throw new IllegalArgumentException("중복된 번호입니다.");
        }
    }
}
