package lotto.domain.type;

import java.util.Arrays;

public enum ResultType {

    SIX(6,2000000000,false),
    FIVE_AND_BONUS(5,3000000,true),
    FIVE(5,1500000,false),
    FOUR(4,50000,false),
    THREE(3,5000,false),
    SORRY(0,0,false);

    private int matchCount;
    private int winningMoney;
    private boolean isBonusMatch;

    private int lottoMatchCount;

    ResultType(int matchCount,int winningMoney,boolean isBonusMatch) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.isBonusMatch = isBonusMatch;
    }
    public int prize(){
        return this.lottoMatchCount * this.winningMoney;
    }

    public int getLottoMatchCount() {
        return lottoMatchCount;
    }

    public static ResultType findType(int matchCount,boolean isBonusMatch){
        return Arrays.stream(values())
                .filter(resultType -> findMatch(resultType,matchCount,isBonusMatch))
                .findFirst()
                .orElse(SORRY);
    }
    private static boolean findMatch(ResultType resultType,int matchCount,boolean isBonusMatch){
        if(matchCount == FIVE_AND_BONUS.matchCount){
            return resultType.eqMachCount(matchCount) && resultType.isBonusMatch == isBonusMatch;
        }
        return resultType.eqMachCount(matchCount);
    }
    public boolean eqMachCount(int matchCount){
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
