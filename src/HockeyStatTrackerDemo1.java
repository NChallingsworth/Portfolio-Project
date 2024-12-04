import components.HockeyStatTracker.HockeyStatTracker;
import components.HockeyStatTracker.HockeyStatTracker1L;

public class HockeyStatTrackerDemo1 {

    public static void main(String[] args) {
        // Initialize the HockeyStatTracker
        HockeyStatTracker tracker = new HockeyStatTracker1L();

        // Add player stats
        tracker.addPlayerStats("Player1", 10, 5, 2);
        tracker.addPlayerStats("Player2", 8, 7, 1);
        tracker.addPlayerStats("Player3", 12, 4, 3);

        // Add goalie stats
        tracker.addGoalieStats("Goalie1", 30, 35);
        tracker.addGoalieStats("Goalie2", 45, 50);

        // Generate and print player rankings
        System.out.println("Player Rankings:");
        System.out.println(tracker.generatePlayerRanking());

        // Calculate and print save percentages for goalies
        System.out.println("Save Percentages:");
        System.out.printf("Goalie1: %.2f%%\n",
                tracker.calculateSavePercentage("Goalie1"));
        System.out.printf("Goalie2: %.2f%%\n",
                tracker.calculateSavePercentage("Goalie2"));
    }
}
