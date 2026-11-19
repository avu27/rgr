package rgr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameAnalytics {
    private final List<Game> games;

    public GameAnalytics(List<Game> games) {
        this.games = new ArrayList<>(games);
    }

    public List<Game> findByPlayerCount(int players) {
        List<Game> result = new ArrayList<>();
        for (Game game : games) {
            if (players >= game.getMinPlayers() && players <= game.getMaxPlayers()) {
                result.add(game);
            }
        }
        return result;
    }

    public List<Game> getTopInGenre(String genre, int limit) {
        List<Game> filtered = new ArrayList<>();
        for (Game game : games) {
            if (game.getGenre().equalsIgnoreCase(genre)) {
                filtered.add(game);
            }
        }
        filtered.sort((g1, g2) -> Double.compare(g2.getRating(), g1.getRating()));
        return filtered.subList(0, Math.min(limit, filtered.size()));
    }

    public Map<String, Integer> getGenreStatistics() {
        Map<String, Integer> stats = new HashMap<>();
        for (Game game : games) {
            String genre = game.getGenre();
            stats.put(genre, stats.getOrDefault(genre, 0) + 1);
        }
        return stats;
    }
}

