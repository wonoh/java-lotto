package lotto.domain;

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
                .map(s -> Integer.parseInt(s.trim()))
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }
    public int matchCount(Lotto winningLotto){
        return (int) this.numbers
                .stream()
                .filter(winningLotto::contains)
                .count();
    }
    private boolean contains(Integer number){
        return this.numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
