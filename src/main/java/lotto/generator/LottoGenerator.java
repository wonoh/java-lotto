package lotto.generator;

import global.RandomUtil;
import lotto.storage.LottoStorage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public List<Integer> makeLotto(){
        List<Integer> lottoNumbers = new ArrayList<>(LottoStorage.lottoNumbers);
        Collections.shuffle(lottoNumbers, RandomUtil.random());
        return lottoNumbers;
    }
}
