import java.util.HashMap;
import java.util.Map;

public class HockeyStatTracker1L extends HockeyStatTrackerSecondary {

    private final Map<String, PlayerStats> playerStats;
    private final Map<String, Integer> teamGoals;

    public HockeyStatTracker1L() {
        this.playerStats = new HashMap<>();
        this.teamGoals = new HashMap<>();
    }

    @Override
    public void addPlayerStats(String player, int goals, int assists,
            int penalties) {
        PlayerStats stats = this.playerStats.getOrDefault(player,
                new PlayerStats());
        stats.goals += goals;
        stats.assists += assists;
        stats.penalties += penalties;
        this.playerStats.put(player, stats);
    }

    @Override
    public void addGoalieStats(String player, int saves, int shotsAgainst) {
        PlayerStats stats = this.playerStats.getOrDefault(player,
                new PlayerStats());
        stats.saves += saves;
        stats.shotsAgainst += shotsAgainst;
        this.playerStats.put(player, stats);
    }

    @Override
    public int getTeamGoals(String team) {
        return this.teamGoals.getOrDefault(team, 0);
    }

    @Override
    protected Iterable<String> getAllPlayers() {
        return this.playerStats.keySet();
    }

    @Override
    protected int getGoals(String player) {
        return this.playerStats.getOrDefault(player, new PlayerStats()).goals;
    }

    @Override
    protected int getAssists(String player) {
        return this.playerStats.getOrDefault(player, new PlayerStats()).assists;
    }

    @Override
    protected int getPenalties(String player) {
        return this.playerStats.getOrDefault(player,
                new PlayerStats()).penalties;
    }

    @Override
    protected int getSaves(String player) {
        return this.playerStats.getOrDefault(player, new PlayerStats()).saves;
    }

    @Override
    protected int getShotsAgainst(String player) {
        return this.playerStats.getOrDefault(player,
                new PlayerStats()).shotsAgainst;
    }

    // Inner class for player stats
    private static class PlayerStats {
        int goals = 0;
        int assists = 0;
        int penalties = 0;
        int saves = 0;
        int shotsAgainst = 0;
    }
}
