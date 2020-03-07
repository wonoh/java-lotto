package lotto.domain;

public class WinningLotto {

    private Lotto lotto;
    private LottoNumber bonusNumber;

    private WinningLotto(Lotto lotto,LottoNumber bonusNumber){

        validateDuplication(bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }
    public static WinningLotto of(String inputNumbers,int bonusNumber){
        LottoNumber bonusLottoNumber = LottoNumber.of(bonusNumber);
        Lotto lotto = Lotto.of(inputNumbers);
        return new WinningLotto(lotto, bonusLottoNumber);
    }
    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
    public Lotto lotto() {
        return lotto;
    }
    private void validateDuplication(LottoNumber bonusNumber){
        if(this.lotto.contains(bonusNumber)){
            throw new IllegalArgumentException(bonusNumber+"는 중복된 번호입니다.");
        }
    }
}
