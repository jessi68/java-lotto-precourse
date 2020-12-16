package domain;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final Lotto lotto;
    private final int BONUS_NUM_INDEX = 5;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        int countOfMatch = this.lotto.sameNumCount(userLotto);
        boolean matchBonus = this.lotto.isBonusEqual(userLotto);
        return Rank.valueOf(countOfMatch, matchBonus);
    }

}
