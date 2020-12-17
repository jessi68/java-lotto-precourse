package view;

import exception.LottoGameException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import validation.Validator;

public class InputView {

    private static final String INPUT_LAST_WINNER_NUM = "지난 주 당첨번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUM = "보너스 볼을 입력해 주세요.";
    private static final String DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public InputView() {

    }

    public static String input(String inputMessage) {
        System.out.println(inputMessage);
        return scanner.next();
    }

    public static List<Integer> strToIntList(String target) {
        try {
            String[] targetArray = target.split(",");
            List<Integer> integerList = new ArrayList<>();
            for (int i = 0; i < targetArray.length; i++) {
                Validator.checkNumType(targetArray[i]);
                Validator.checkValidRange(Integer.parseInt(targetArray[i]));
                integerList.add(Integer.parseInt(targetArray[i]));
            }
            return integerList;
        } catch(LottoGameException e){
            throw new LottoGameException(e.getMessage());
        }

    }

    public static List<Integer> inputWinnerNums() {
        try {
            String string = input(INPUT_LAST_WINNER_NUM);
            return strToIntList(string);
        } catch(LottoGameException e){
            return inputWinnerNums();
        }
    }

    public static int inputBonusNum() {
        try {
            Validator.checkNumType(input(INPUT_BONUS_NUM));
            return Integer.parseInt(input(INPUT_BONUS_NUM));
        } catch(LottoGameException e) {
            return inputBonusNum();
        }
    }

}
