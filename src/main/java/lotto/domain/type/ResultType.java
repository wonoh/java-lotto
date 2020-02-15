package lotto.domain.type;

import java.util.Arrays;

public enum ResultType {

    SIX(6,"6개 일치 (2000000000원)",2000000000),
    FIVE(5,"5개 일치 (1500000원)",1500000),
    FOUR(4,"4개 일치 (50000원)",50000),
    THREE(3,"3개 일치 (5000원)",5000),
    SORRY(0,"꽝",0);

    private int matchCount;
    private String message;
    private int winningMoney;

    private int lottoMatchCount;

    ResultType(int matchCount,String message, int winningMoney) {
        this.matchCount = matchCount;
        this.message = message;
        this.winningMoney = winningMoney;
    }
    public int prize(){
        return this.lottoMatchCount * this.winningMoney;
    }

    public int getLottoMatchCount() {
        return lottoMatchCount;
    }

    public static ResultType findType(int matchCount){
        return Arrays.stream(values())
                .filter(resultType -> resultType.hasCount(matchCount))
                .findFirst()
                .orElse(SORRY);
    }
    public boolean hasCount(int matchCount){
        return this.matchCount == matchCount;
    }
    public void plusLottoMatchCount(){
        this.lottoMatchCount++;
    }

    public String getMessage() {
        return message;
    }

}
