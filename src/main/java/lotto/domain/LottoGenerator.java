package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final int START = 1;
    private static final int END = 45;
    private static final int PICK_START_INDEX = 30;
    private static final int PICK_END_INDEX = 36;

    public static LottoStore generateLottoStore(Money money){
        List<Lotto> lottoNumbers = IntStream.range(0, money.lottoCount())
                                    .mapToObj(i -> generateLotto())
                                    .collect(Collectors.toList());
        return LottoStore.of(lottoNumbers);
    }
    private static Lotto generateLotto(){
        List<Integer> initNumbers = initNumbers();
        Collections.shuffle(initNumbers);
        final List<Integer> lottoNumbers = pickLottoNumbers(initNumbers);
        Collections.sort(lottoNumbers);
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
