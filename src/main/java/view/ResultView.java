package view;

import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.domain.Result;
import lotto.domain.Results;
import lotto.domain.type.ResultType;

import java.util.List;

public class ResultView {

    public static void printLotto(LottoStore lottoStore) {
        List<Lotto> lottos = lottoStore.getLottos();
        System.out.println(lottos.size()+"개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResults(Results results) {
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append("당첨 통계\n"+"------"+"\n");
        for (Result result : results.getResults()) {
            final ResultType resultType = result.getResultType();
            resultBuilder.append(resultType.getMatchCount())
                    .append("개 일치");
            if(resultType.equals(ResultType.FIVE_AND_BONUS)){
                resultBuilder.append(", 보너스볼 일치");
            }
            resultBuilder.append("(")
                    .append(resultType.getWinningMoney())
                    .append(") - ")
                    .append(resultType.getLottoMatchCount())
                    .append("개\n");
        }

        resultBuilder.append("총 수익률은 ")
                .append(results.getYield())
                .append("%입니다.");
        System.out.println(resultBuilder.toString());
    }
}
