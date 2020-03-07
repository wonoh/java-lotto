package lotto.domain;

import java.util.Objects;

import static lotto.domain.constant.LottoConstants.LOTTO_END_NUMBER;
import static lotto.domain.constant.LottoConstants.LOTTO_START_NUMBER;

public class LottoNumber implements Comparable<LottoNumber> {

    private int number;

    private LottoNumber(int number){
        validateNumber(number);
        this.number = number;
    }
    public static LottoNumber of(int number){
        return new LottoNumber(number);
    }

    private void validateNumber(int number) {
        if(number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER){
            throw new IllegalArgumentException("로또 숫자는"+LOTTO_START_NUMBER+"~"+LOTTO_END_NUMBER+"의 범위여야 합니다.");
        }
    }
    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return number - o.number;
    }
}
