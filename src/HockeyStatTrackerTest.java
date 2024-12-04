<<<<<<< HEAD

=======
>>>>>>> 508e50cc1c43679691d0095c60372e9b7607ec76
public class HockeyStatTrackerTest {
    public static void main(String[] args) {
        HockeyStatTracker tracker = new HockeyStatTracker1L();

        tracker.addPlayerStats("Player1", 10, 5, 2);
        tracker.addPlayerStats("Player2", 7, 8, 1);
        tracker.addGoalieStats("Goalie1", 20, 25);

        System.out.println("Player Rankings:");
        System.out.println(tracker.generatePlayerRanking());

        System.out.println("Save Percentage for Goalie1: "
                + tracker.calculateSavePercentage("Goalie1") + "%");

        tracker.addPlayerStats("Player1", 5, 3, 1); // Updating existing player stats
        System.out.println("Updated Player Rankings:");
        System.out.println(tracker.generatePlayerRanking());
    }
}
