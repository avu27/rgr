package rgr;

public class Game {
    private final String name;
    private final String genre;
    private final int minPlayers;
    private final int maxPlayers;
    private final double rating;

    public Game(String name, String genre, int minPlayers, int maxPlayers, double rating) {
        this.name = name;
        this.genre = genre;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return String.format("%s [%s] | Игроки: %d-%d | Рейтинг: %.1f",
                name, genre, minPlayers, maxPlayers, rating);
    }
}

