package service;

import java.util.List;
import java.util.Random;
import utils.RandomUtils;

public class LottoController {

    public LottoController() {

    }

    public void generateLottoNum() {
        Random random = new Random();
        for(int index = 0; index < NUM_COUNT; index++) {
            numbers.add(RandomUtils.nextInt(MIN_NUM, MAX_NUM));
        }
    }
}
