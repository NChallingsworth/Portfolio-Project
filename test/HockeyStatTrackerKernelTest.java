
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import components.HockeyStatTracker.HockeyStatTracker;
import components.HockeyStatTracker.HockeyStatTracker1L;

public class HockeyStatTrackerKernelTest {

    private HockeyStatTracker tracker;

    @Before
    public void setUp() {
        this.tracker = new HockeyStatTracker1L();
    }

    @Test
    public void testAddPlayerStats() {
        this.tracker.addPlayerStats("Player1", 3, 5, 2);
        String playerRanking = this.tracker.generatePlayerRanking();
        // Check that the player ranking contains the expected stats
        String expected = "Player1 - Goals: 3, Assists: 5, Penalties: 2\n";
        assertEquals(expected, playerRanking);
    }

    @Test
    public void testAddGoalieStats() {
        this.tracker.addGoalieStats("Goalie1", 25, 30);
        float savePercentage = this.tracker.calculateSavePercentage("Goalie1");
        // Check that save percentage is calculated correctly
        assertEquals(83.33f, savePercentage, 0.01f);
    }

    @Test
    public void testGetTeamGoals_NoGoals() {
        String teamSummary = this.tracker.generateTeamSummary("TeamA");
        // Check that team summary reports 0 goals
        assertEquals("Team TeamA has scored 0 goals this season.", teamSummary);
    }

    @Test
    public void testAddPlayerStats_UpdatesExistingPlayer() {
        this.tracker.addPlayerStats("Player1", 3, 5, 2);
        this.tracker.addPlayerStats("Player1", 2, 1, 0);
        String playerRanking = this.tracker.generatePlayerRanking();
        // Check that the player ranking reflects the updated stats
        String expected = "Player1 - Goals: 5, Assists: 6, Penalties: 2\n";
        assertEquals(expected, playerRanking);
    }
}
