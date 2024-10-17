//Nick Challingsworth
//Challingsworth.1

public interface HockeyStatTracker extends HockeyStatTrackerKernel {

    /**
     * Generates a ranking report for all players based on their stats.
     *
     * @return a string representing player rankings with goals, assists, and
     *         penalties
     * @ensures the string contains rankings of all players stored in the
     *          tracker
     */
    String generatePlayerRanking();

    /**
     * Calculates the save percentage for a given goalie.
     *
     * @param player
     *            the name of the goalie
     * @return the save percentage as a float value
     * @requires the player exists in the tracker and has shots against > 0
     * @ensures the returned value is between 0 and 100
     */
    float calculateSavePercentage(String player);

    /**
     * Generates a summary for a specific team's performance.
     *
     * @param team
     *            the name of the team
     * @return a summary string indicating the number of goals the team has
     *         scored
     * @ensures the string contains the total goals for the specified team
     */
    String generateTeamSummary(String team);
}
