package domain;

import java.util.HashMap;
import java.util.List;

public class User {

    private List<Lotto> lottoRepository;
    private HashMap<Rank, Integer> rankStatistics;
    private Rank rank;

    User(List<Lotto> lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public HashMap<Rank, Integer> getRankStatistics() {
        return rankStatistics;
    }

    private void updateRankStatistics(WinningLotto winningLotto) {
        Rank curRank;
        for(Lotto lotto: lottoRepository) {
            curRank = winningLotto.match(lotto);
            rankStatistics.put(curRank, rankStatistics.get(curRank) + 1);
        }
    }

}
