package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private List<Integer> numbers;

    private Lotto(List<Integer> numbers){
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers){
        return new Lotto(numbers);
    }
    public static Lotto of(String inputNumbers){
        String[] split = inputNumbers.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String s : split) {
            numbers.add(Integer.parseInt(s.trim()));
        }
        return new Lotto(numbers);
    }
    public int matchCount(Lotto winningLotto){
        int matchCount = 0;
        for (Integer number : this.numbers) {
            if(winningLotto.contains(number)){
                matchCount++;
            }
        }
        return matchCount;
    }
    private boolean contains(Integer number){
        return this.numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
