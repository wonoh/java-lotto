package lotto.domain;

import lotto.domain.type.ResultType;

import java.util.List;

public class LottoStore {

    private final List<Lotto> lottos;

    public int lottoCount(){
        return this.lottos.size();
    }

    private LottoStore(List<Lotto> lottos){
        this.lottos = lottos;
    }
    public static LottoStore of(List<Lotto> lottos){
        return new LottoStore(lottos);
    }
    public Results createResults(WinningLotto winningLotto){
        Results results = Results.of(this);
        for (Lotto lotto : this.lottos) {
            int matchCount = lotto.matchCount(winningLotto.lotto());
            ResultType resultType = ResultType.findType(matchCount);
            resultType.plusLottoMatchCount();
        }
        return results;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
