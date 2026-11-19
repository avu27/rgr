package rgr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameFileReader {
    private static final Logger logger = Logger.getLogger(GameFileReader.class.getName());

    public List<Game> readGames(Path filePath) {
        List<Game> games = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath.toFile()))) {
            String line;
            int lineNum = 0;

            while ((line = br.readLine()) != null) {
                lineNum++;
                if (line.isBlank()) {
                    continue;
                }

                String[] parts = line.split(";");
                if (parts.length != 5) {
                    logger.log(Level.WARNING, "Строка {0}: неверное количество полей. Пропуск: {1}",
                            new Object[]{lineNum, line});
                    continue;
                }

                try {
                    String name = parts[0].trim();
                    String genre = parts[1].trim();
                    int minPlayers = Integer.parseInt(parts[2].trim());
                    int maxPlayers = Integer.parseInt(parts[3].trim());
                    double rating = Double.parseDouble(parts[4].trim());

                    games.add(new Game(name, genre, minPlayers, maxPlayers, rating));
                } catch (NumberFormatException e) {
                    logger.log(Level.WARNING, "Строка {0}: ошибка формата числа. Пропуск: {1}",
                            new Object[]{lineNum, line});
                }
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка при чтении файла: " + filePath, e);
        }

        return games;
    }
}
