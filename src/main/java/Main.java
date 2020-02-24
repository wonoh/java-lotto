import lotto.domain.*;
import view.InputView;
import view.ResultView;

public class Main {
    public static void main(String[] args){

        Money money = Money.of(InputView.inputMoney());
        LottoStore lottoStore = LottoGenerator.generateLottoStore(money);
        ResultView.printLotto(lottoStore);

        WinningLotto winningLotto = WinningLotto.of(
                InputView.inputWinningLotto(),
                InputView.inputBonusNumber()
        );
        Results results = lottoStore.createResults(winningLotto);
        ResultView.printResults(results);
    }
}
