package lotto.domain;

import lotto.domain.type.ResultType;

public class Result {

    private final ResultType resultType;

    private Result(ResultType resultType){
        this.resultType = resultType;
    }
    public static Result of(ResultType resultType){
        return new Result(resultType);
    }

    public int getPrize(){
        return resultType.prize();
    }

    public ResultType getResultType() {
        return resultType;
    }

}
