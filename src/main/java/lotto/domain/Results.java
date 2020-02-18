package lotto.domain;

import lotto.domain.type.ResultType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Results {

    private final List<Result> results = new ArrayList<>();
    private final LottoStore lottoStore;

    private Results(LottoStore lottoStore){
        this.lottoStore = lottoStore;
        initResults();
    }

    private void initResults() {
        for (ResultType resultType: ResultType.values()){
            results.add(Result.of(resultType));
        }
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }

    public double getYield(){
        int winningMoney = 0;
        for (Result result : results) {
            winningMoney += result.getPrize();
        }
        Money earnMoney = Money.of(winningMoney);
        Money lottoMoney = Money.of(lottoStore.getLottos());
        return lottoMoney.yield(earnMoney);
    }
    public static Results of(LottoStore lottoStore){
        return new Results(lottoStore);
    }

}
