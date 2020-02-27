package lotto.domain;

import lotto.domain.type.ResultType;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static lotto.domain.constant.LottoConstants.LOTTO_SIZE;

public class LottoStore {

    private final List<Lotto> lottos;

    private LottoStore(List<Lotto> lottos){
        validateLottos(lottos);
        this.lottos = lottos;
    }
    public static LottoStore of(List<Lotto> lottos){
        return new LottoStore(lottos);
    }
    public Results createResults(WinningLotto winningLotto){
        Results results = Results.of(this);
        for (Lotto lotto : this.lottos) {
            ResultType resultType = lotto.findResultTypeByMatchCount(winningLotto);
            resultType.plusLottoMatchCount();
        }
        return results;
    }
    private void validateLottos(List<Lotto> lottos){
        if(Objects.isNull(lottos)){
            throw new IllegalArgumentException("로또번호는 존재해야 합니다.");
        }
    }
    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
