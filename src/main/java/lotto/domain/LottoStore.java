package lotto.domain;

import lotto.domain.type.ResultType;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStore {

    private final List<Lotto> lottos;
    private int size;
    private int manualLottoCount;

    public int getSize() {
        return this.lottos.size();
    }

    private LottoStore(List<Lotto> autoLottos, List<Lotto> manualLotts ){
        validateLottos(autoLottos);
        validateLottos(manualLotts);
        this.lottos = Stream.concat(
                                manualLotts.stream(),
                                autoLottos.stream())
                        .collect(Collectors.toList());
        this.manualLottoCount = manualLotts.size();
    }
    public static LottoStore of(List<Lotto> autoLottos,List<Lotto> manualLotts){
        return new LottoStore(autoLottos,manualLotts);
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

    public int getManualLottoCount() {
        return manualLottoCount;
    }
}
