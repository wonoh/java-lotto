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
    public ResultType findResultTypeByMatchCount(Lotto winningLotto){
        final int matchCount = (int) this.numbers
                            .stream()
                            .filter(winningLotto::contains)
                            .count();
        return ResultType.findType(matchCount);
    }
    private boolean contains(Integer number){
        return this.numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
