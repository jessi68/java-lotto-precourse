package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import utils.RandomUtils;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {

    private final static int BONUS_INDEX = 5;
    private final static int COUNT_OF_NUM = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getNum(int index) {
        return this.numbers.get(index);
    }

    public boolean isBonusEqual(Lotto userLotto) {
        return this.getNum(BONUS_INDEX) == userLotto.getNum(BONUS_INDEX);
    }

    public int countOfSameNum(Lotto userLotto) {
        int count = 0;
        for(int index = 0; index < COUNT_OF_NUM; index++) {
            if(this.getNum(index) == userLotto.getNum(index)) {
                count += 1;
            }
        }
        return count;
    }




}
