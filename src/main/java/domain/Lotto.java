package domain;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {

    private final static int NUM_COUNT = 6;
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getNum(int index) {
        return this.numbers.get(index);
    }

    public int sameNumCount(Lotto userLotto) {
        int count = 0;
        for(int index = 0; index < NUM_COUNT; index++) {
            if(this.getNum(index) == userLotto.getNum(index)) {
                count += 1;
            }
        }
        return count;
    }
    // 추가 기능 구현
}
