package domain;

import exception.LottoGameException;
import java.util.Arrays;

/**
 * 로또 등수를 의미하는 enum
 */
public enum Rank {
    FIRST(6, 2_000_000_000), // 1등
    SECOND(5, 30_000_000), // 2등
    THIRD(5, 1_500_000), // 3등
    FOURTH(4, 50_000), // 4등
    FIFTH(3, 5_000), // 5등
    MISS(0, 0);

    private static final int WINNING_MIN_COUNT = 3;
    private static final String NOT_VALID_VALUE = "는 유효하지 않은 값입니다.";
    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static boolean defeated(int countOfMatch) {
        return countOfMatch < WINNING_MIN_COUNT;
    }

    public static boolean isSecond(int countOfMatch, boolean matchBonus) {
        return SECOND.matchCount(countOfMatch) && matchBonus;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        try {
            if (defeated(countOfMatch)) {
                return MISS;
            }

            if (isSecond(countOfMatch, matchBonus)) {
                return SECOND;
            }

            return Arrays.stream(values())
                  .filter(rank -> rank.matchCount(countOfMatch))
                  .findFirst()
                  .get();
        } catch(Exception e) {
            throw new LottoGameException(countOfMatch + NOT_VALID_VALUE);
        }
    }

    private boolean matchCount(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }
}

