package service;

import domain.Lotto;
import domain.WinningLotto;
import exception.LottoGameException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import utils.RandomUtils;

import view.InputView;
import view.OutputView;

public class LottoGenerator {

    private final static int INCLUSIVE_START = 0;
    private final static int EXCLUSIVE_END = 6;
    private final static int MIN_NUM = 1;
    private final static int MAX_NUM = 45;

    public LottoGenerator() {

    }

    public static Lotto userLotto() {
        List<Integer> numbers= IntStream.range(MIN_NUM, MAX_NUM + 1)
                               .boxed()
                               .collect(Collectors.toList());
        Random random = new Random();
        Collections.shuffle(numbers);
        return new Lotto(numbers.subList(INCLUSIVE_START, EXCLUSIVE_END));
    }

    public static WinningLotto winnerLotto() {
        try {
            List<Integer> winnerNums = InputView.inputWinnerNums();
            int bonusNum = InputView.inputBonusNum();
            return new WinningLotto(new Lotto(winnerNums), bonusNum);
        } catch(LottoGameException e) {
            OutputView.printErrorInfo(e.getMessage());
            return winnerLotto();
        }
    }

}
