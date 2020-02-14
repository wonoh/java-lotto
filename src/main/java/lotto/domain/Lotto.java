package lotto.domain;

import java.util.List;

public class Lotto {

    private List<Integer> numbers;

    private Lotto(List<Integer> numbers){
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers){
        return new Lotto(numbers);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
