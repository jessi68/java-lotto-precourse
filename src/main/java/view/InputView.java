package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public static List<Integer> strToIntList(String string) {
        String[] strArray = string.split(",");
        List<Integer> integerList = new ArrayList<>();
        for(int i = 0; i < strArray.length; i++) {
            integerList.add(Integer.parseInt(strArray[i]));
        }
        return integerList;
    }

    public static List<Integer> inputWinnerNums() {
        String string = input(INPUT_LAST_WINNER_NUM);
        return strToIntList(string);
    }

    public static int inputBonusNum() {
        return Integer.parseInt(input(INPUT_BONUS_NUM));
    }
}
