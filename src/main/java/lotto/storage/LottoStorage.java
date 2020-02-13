package lotto.storage;

import java.util.ArrayList;
import java.util.List;

public final class LottoStorage {

    private LottoStorage() {
    }

    public static int PRICE;
    public static List<Integer> lottoNumbers;

    static{
        PRICE = 1000;
        lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 45 ; i++) {
            lottoNumbers.add(i);
        }
    }

}
