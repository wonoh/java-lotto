package lotto.domain;

public class Money {

    private static final int LOTTO_PRICE = 1000;

    private int money;

    private Money(int money){
        this.money = money;
    }

    public static Money of(int money){
        return new Money(money);
    }
    public static Money of(LottoStore lottoStore){
        return new Money(lottoStore.lottoCount()*LOTTO_PRICE);
    }

    public int lottoCount(){
        return this.money / LOTTO_PRICE;
    }
    public double yield(Money money){
        return (money.money * 100) / this.money;
    }

    public int getMoney() {
        return money;
    }
}
