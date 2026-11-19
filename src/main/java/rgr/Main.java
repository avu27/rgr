package rgr;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Path filePath = Paths.get("data", "games.txt");
        GameFileReader reader = new GameFileReader();
        List<Game> catalog = reader.readGames(filePath);

        System.out.println("Успешно загружено игр: " + catalog.size());
        GameAnalytics analytics = new GameAnalytics(catalog);

        System.out.println("\n1. Игры для компании из 4 человек:");
        for (Game g : analytics.findByPlayerCount(4)) {
            System.out.println(" - " + g);
        }

        System.out.println("\n2. Топ-2 игры в жанре RPG:");
        for (Game g : analytics.getTopInGenre("RPG", 2)) {
            System.out.println(" - " + g);
        }

        System.out.println("\n3. Статистика по жанрам:");
        for (Map.Entry<String, Integer> entry : analytics.getGenreStatistics().entrySet()) {
            System.out.println(" - " + entry.getKey() + ": " + entry.getValue() + " шт.");
        }
    }
}

