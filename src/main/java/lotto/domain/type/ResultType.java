package lotto.domain.type;

import java.util.Arrays;

public enum ResultType {

    SIX(6,2000000000),
    FIVE(5,500000),
    FOUR(4,50000),
    THREE(3,5000),
    SORRY(0,0);

    private int matchCount;
    private int winningMoney;

    private int lottoMatchCount;

    ResultType(int matchCount,int winningMoney) {
        this.matchCount = matchCount;
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

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
