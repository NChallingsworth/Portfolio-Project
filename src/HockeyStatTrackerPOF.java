/*Nick Challingsworth
 * challingsworth.1
 * due 10/3/24 @ 4:10
 */

//I was going to use the util version of map and HashMap because it is what I got used to using in highschool, please let me know if I should change it
import java.util.HashMap;
import java.util.Map;

public class HockeyStatTracker {

    // Maps to stre player stats and team goals
    private Map<String, PlayerStats> playerStats;
    private Map<String, Integer> teamGoals;

    // Construct
    public HockeyStatTracker() {
        this.playerStats = new HashMap<>();
        this.teamGoals = new HashMap<>();
    }

    // Kernel Methods
    public void addPlayerStats(String player, int goals, int assists,
            int penalties) {
        PlayerStats stats = this.playerStats.getOrDefault(player,
                new PlayerStats());
        stats.goals += goals;
        stats.assists += assists;
        stats.penalties += penalties;
        this.playerStats.put(player, stats);

        this.teamGoals.put("Team A",
                this.teamGoals.getOrDefault("Team A", 0) + goals);
    }

    public void addGoalieStats(String player, int saves, int shotsAgainst) {
        PlayerStats stats = this.playerStats.getOrDefault(player,
                new PlayerStats());
        stats.saves += saves;
        stats.shotsAgainst += shotsAgainst;
        this.playerStats.put(player, stats);
    }

    public int getTeamGoals(String team) {
        return this.teamGoals.getOrDefault(team, 0);
    }

    // Secondary Methods
    public String generatePlayerRanking() {
        StringBuilder rankings = new StringBuilder();
        this.playerStats.forEach((player, stats) -> {
            rankings.append(player).append(" - Goals: ").append(stats.goals)
                    .append(", Assists: ").append(stats.assists)
                    .append(", Penalties: ").append(stats.penalties)
                    .append("\n");
        });
        return rankings.toString();
    }

    public float calculateSavePercentage(String player) {
        PlayerStats stats = this.playerStats.get(player);
        if (stats != null && stats.shotsAgainst > 0) {
            return ((float) stats.saves / stats.shotsAgainst) * 100;
        }
        return 0.0f;
    }

    public String generateTeamSummary(String team) {
        return "Team " + team + " has scored " + this.getTeamGoals(team)
                + " goals this season.";
    }

    // Main method for testing and POC
    public static void main(String[] args) {
        HockeyStatTracker tracker = new HockeyStatTracker();

        //p stats
        tracker.addPlayerStats("Player 1", 2, 1, 0);
        tracker.addPlayerStats("Player 2", 1, 2, 1);
        tracker.addGoalieStats("Goalie 1", 25, 30);

        //team goals
        System.out.println(tracker.generateTeamSummary("Team A"));

        //p ranks
        System.out.println("Player Rankings:");
        System.out.println(tracker.generatePlayerRanking());

        //goalie %
        System.out.println("Goalie 1 Save Percentage: "
                + tracker.calculateSavePercentage("Goalie 1") + "%");
    }

    // Inner class to store player stats for testing
    private class PlayerStats {
        int goals = 0;
        int assists = 0;
        int penalties = 0;
        int saves = 0;
        int shotsAgainst = 0;
    }
}
