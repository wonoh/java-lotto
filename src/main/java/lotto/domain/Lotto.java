package lotto.domain;

import lotto.domain.type.ResultType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private List<Integer> numbers;
    private static final String COMMA = ",";

    private Lotto(List<Integer> numbers){
        this.numbers = numbers;
    }
    public static Lotto of(List<Integer> numbers){
        return new Lotto(numbers);
    }
    public static Lotto of(String inputNumbers){
        List<Integer> numbers = Arrays.stream(inputNumbers.split(COMMA))
                .map(inputNumber -> Integer.parseInt(inputNumber.trim()))
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }
    public ResultType findResultTypeByMatchCount(WinningLotto winningLotto){
        Lotto lotto = winningLotto.lotto();
        final int matchCount = (int) this.numbers
                            .stream()
                            .filter(lotto::contains)
                            .count();
        final boolean isBonusMatch = contains(winningLotto.getBonusNumber());
        return ResultType.findType(matchCount,isBonusMatch);
    }
    public boolean contains(Integer number){
        return this.numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
