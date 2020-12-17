package domain;

import java.util.HashMap;
import java.util.List;

public class LottoRepository {

    private static final int DEFAULT_VALUE = 0;
    private List<Lotto> lottos;
    private WinningLotto winningLotto;
    private HashMap<Rank, Integer> rankStatistics;

    public LottoRepository() {
        initializeRankStatistics();
        updateRankStatistics();
    }

    private void initializeRankStatistics() {
        for(Rank value: Rank.values()) {
            rankStatistics.put(value, DEFAULT_VALUE);
        }
    }

    private void updateRankStatistics() {
        Rank curRank;
        for(Lotto lotto: lottos) {
            curRank = winningLotto.match(lotto);
            rankStatistics.put(curRank, rankStatistics.get(curRank) + 1);
        }
    }

}
