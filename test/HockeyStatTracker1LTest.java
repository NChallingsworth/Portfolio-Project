import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import components.HockeyStatTracker.HockeyStatTracker1L;

public class HockeyStatTracker1LTest {

    private HockeyStatTracker1L tracker;

    @Before
    public void setUp() {
        this.tracker = new HockeyStatTracker1L();
    }

    @Test
    public void testGeneratePlayerRanking() {
        this.tracker.addPlayerStats("Player1", 3, 5, 2);
        this.tracker.addPlayerStats("Player2", 2, 1, 0);
        String ranking = this.tracker.generatePlayerRanking();

        // Verify that both players' stats are in the output
        assertTrue(ranking
                .contains("Player1 - Goals: 3, Assists: 5, Penalties: 2"));
        assertTrue(ranking
                .contains("Player2 - Goals: 2, Assists: 1, Penalties: 0"));
    }

    @Test
    public void testCalculateSavePercentage() {
        this.tracker.addGoalieStats("Goalie1", 25, 50);
        assertEquals(50.0f, this.tracker.calculateSavePercentage("Goalie1"),
                0.01f);
    }

    @Test
    public void testCalculateSavePercentage_NoShotsAgainst() {
        this.tracker.addGoalieStats("Goalie1", 25, 0);
        assertEquals(0.0f, this.tracker.calculateSavePercentage("Goalie1"),
                0.01f);
    }

    @Test
    public void testGenerateTeamSummary() {
        this.tracker.addPlayerStats("Player1", 3, 5, 2);
        this.tracker.addPlayerStats("Player2", 2, 1, 0);
        String summary = this.tracker.generateTeamSummary("TeamA");
        assertEquals("Team TeamA has scored 0 goals this season.", summary);
    }
}
