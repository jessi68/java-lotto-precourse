package validation;

import exception.LottoGameException;

public class Validator {

    private static final String ENTER_NUMBER = "숫자를 입력해주세요.";
    private static final String NUM_RANGE_NOTICE = "1 부터 45 사이에 있는 숫자를 입력해주세요.";
    private static final String INSUFFICIENT_MONEY = "구매할 돈이 부족합니다.";
    private final static int MIN_NUM = 1;
    private final static int MAX_NUM = 45;
    private final static int LEAST_MONEY = 1000;

    Validator() {

    }

    public static void isValidMoney(int money) {
        if(money < LEAST_MONEY) {
            throw new LottoGameException(INSUFFICIENT_MONEY);
        }
    }

    public static void checkNumType(String target) {
        try {
            Integer.parseInt(target);
        } catch(NumberFormatException e) {
            throw new LottoGameException(ENTER_NUMBER);
        }
    }

    public static void checkValidRange(int target) {
        if(target <MIN_NUM || target >MAX_NUM) {
            throw new LottoGameException(NUM_RANGE_NOTICE);
        }
    }

}
