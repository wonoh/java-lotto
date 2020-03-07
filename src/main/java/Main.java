import lotto.domain.*;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){

        Money money = Money.of(InputView.inputMoney());
        int manualLottoCount = InputView.inputManualLottoCount();
        List<String> inputManualLotts = InputView.inputManualLottoNumbers(manualLottoCount);

        LottoStore lottoStore = LottoGenerator.generateLottoStore(money,inputManualLotts);
        ResultView.printLotto(lottoStore);

        String inputWinningNumber = InputView.inputWinningLotto();
        int inputBonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = WinningLotto.of(inputWinningNumber,inputBonusNumber);
        Results results = lottoStore.createResults(winningLotto);
        ResultView.printResults(results);
    }
}
