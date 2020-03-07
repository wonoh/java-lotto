package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final int START = 1;
    private static final int END = 45;
    private static final int PICK_START_INDEX = 30;
    private static final int PICK_END_INDEX = 36;

    private static List<Integer> lottoNumberPool;
    static{
        lottoNumberPool = initNumbers();
    }

    public static LottoStore generateLottoStore(Money money,List<String> inputManualLottos){
        List<Lotto> manualLottos = createManualLottos(inputManualLottos);
        int autoLottoCount = money.lottoCount() - manualLottos.size();
        List<Lotto> autoLottos = IntStream.range(0, autoLottoCount)
                                    .mapToObj(i -> generateLotto())
                                    .collect(Collectors.toList());
        return LottoStore.of(autoLottos,manualLottos);
    }
    private static List<Lotto> createManualLottos(List<String> inputManualLottos){
        return inputManualLottos.stream()
                .map(Lotto::of)
                .collect(Collectors.toList());
    }
    private static Lotto generateLotto(){
        final List<Integer> newNumbers = new ArrayList<>(lottoNumberPool);
        Collections.shuffle(newNumbers);
        final List<Integer> pickNumbers = pickLottoNumbers(newNumbers);
        List<LottoNumber> lottoNumbers = pickNumbers.stream()
                                        .map(LottoNumber::of)
                                        .collect(Collectors.toList());
        return Lotto.of(lottoNumbers);
    }
    private static List<Integer> pickLottoNumbers(List<Integer> initNumbers){
        return initNumbers.subList(PICK_START_INDEX,PICK_END_INDEX);
    }
    private static List<Integer> initNumbers(){
        return IntStream
                .rangeClosed(START,END)
                .boxed()
                .collect(Collectors.toList());
    }

}
