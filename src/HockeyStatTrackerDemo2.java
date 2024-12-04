import components.HockeyStatTracker.HockeyStatTracker;
import components.HockeyStatTracker.HockeyStatTracker1L;

public class HockeyStatTrackerDemo2 {

    public static void main(String[] args) {
        // Initialize the HockeyStatTracker
        HockeyStatTracker tracker = new HockeyStatTracker1L();

        // Add player stats
        tracker.addPlayerStats("Player1", 6, 2, 1);
        tracker.addPlayerStats("Player2", 4, 3, 2);

        // Simulate adding team goals
        tracker.addPlayerStats("TeamA", 10, 0, 0);
        tracker.addPlayerStats("TeamB", 8, 0, 0);

        // Generate and print team summaries
        System.out.println("Team Summaries:");
        System.out.println(tracker.generateTeamSummary("TeamA"));
        System.out.println(tracker.generateTeamSummary("TeamB"));
    }
}
