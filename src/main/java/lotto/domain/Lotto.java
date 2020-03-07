package lotto.domain;

import lotto.domain.type.ResultType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static lotto.domain.constant.LottoConstants.LOTTO_SIZE;

public class Lotto {

    private List<LottoNumber> numbers;
    private static final String COMMA = ",";

    private Lotto(List<LottoNumber> numbers){
        validateLottoNumbers(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validateLottoNumbers(List<LottoNumber> numbers) {
        if(Objects.isNull(numbers)){
            throw new IllegalArgumentException("로또번호는 존재해야 합니다.");
        }
        if(numbers.size() != LOTTO_SIZE){
            throw new IllegalArgumentException("로또숫자는"+LOTTO_SIZE+"개 이어야 합니다.");
        }
    }

    public static Lotto of(List<LottoNumber> numbers){
        return new Lotto(numbers);
    }
    public static Lotto of(String inputNumbers){
        List<LottoNumber> numbers = Arrays.stream(inputNumbers.split(COMMA))
                .map(inputNumber -> Integer.parseInt(inputNumber.trim()))
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }
    public ResultType findResultTypeByMatchCount(WinningLotto winningLotto){
        Lotto lotto = winningLotto.lotto();
        LottoNumber bonusNumber = winningLotto.getBonusNumber();
        final int matchCount = (int) this.numbers
                            .stream()
                            .filter(lotto::contains)
                            .count();
        final boolean isBonusMatch = contains(bonusNumber);
        return ResultType.findType(matchCount,isBonusMatch);
    }
    public boolean contains(LottoNumber number){
        return this.numbers.contains(number);
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
