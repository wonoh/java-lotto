package lotto.domain;

public class WinningLotto {

    private Lotto lotto;

    private WinningLotto(Lotto lotto){
        this.lotto = lotto;
    }
    public static WinningLotto of(String inputNumbers){
        return new WinningLotto(Lotto.of(inputNumbers));
    }

    public Lotto lotto() {
        return lotto;
    }
}
