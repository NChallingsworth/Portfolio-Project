package components.HockeyStatTracker;
// Nick Challingsworth

// challingsworth.1

/**
 * Abstract class that implements {@code HockeyStatTracker}. Provides default
 * implementations for derived methods using kernel methods.
 */
public abstract class HockeyStatTrackerSecondary implements HockeyStatTracker {

    /**
     * Generates a ranking report for all players based on their stats. Uses
     * only kernel methods to build the report.
     *
     * @return a string representing player rankings with goals, assists, and
     *         penalties
     * @ensures the string contains rankings of all players stored in the
     *          tracker
     */
    @Override
    public String generatePlayerRanking() {
        StringBuilder rankings = new StringBuilder();
        // Using kernel methods (or placeholders) to add player stats to rankings
        for (String player : this.getAllPlayers()) {
            rankings.append(player).append(" - Goals: ")
                    .append(this.getGoals(player)).append(", Assists: ")
                    .append(this.getAssists(player)).append(", Penalties: ")
                    .append(this.getPenalties(player)).append("\n");
        }
        return rankings.toString();
    }

    /**
     * Calculates the save percentage for a given goalie. Uses only kernel
     * methods for calculation.
     *
     * @param player
     *            the name of the goalie
     * @return the save percentage as a float value
     * @requires the player exists in the tracker and has shots against > 0
     * @ensures the returned value is between 0 and 100
     */
    @Override
    public float calculateSavePercentage(String player) {
        int saves = this.getSaves(player);
        int shotsAgainst = this.getShotsAgainst(player);
        if (shotsAgainst > 0) {
            return ((float) saves / shotsAgainst) * 100;
        }
        return 0.0f;
    }

    /**
     * Generates a summary for a specific team's performance. Uses only kernel
     * methods to retrieve team data.
     *
     * @param team
     *            the name of the team
     * @return a summary string indicating the number of goals the team has
     *         scored
     * @ensures the string contains the total goals for the specified team
     */
    @Override
    public String generateTeamSummary(String team) {
        return "Team " + team + " has scored " + this.getTeamGoals(team)
                + " goals this season.";
    }

    /**
     * Returns a string representation of the tracker. Uses only kernel methods.
     */
    @Override
    public String toString() {
        return "HockeyStatTracker: " + this.generatePlayerRanking();
    }

    /**
     * Checks if this tracker is equal to another object. Uses only kernel
     * methods.
     *
     * @param obj
     *            the object to compare
     * @return true if the trackers are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof HockeyStatTracker)) {
            return false;
        }
        HockeyStatTracker other = (HockeyStatTracker) obj;
        return this.generatePlayerRanking()
                .equals(other.generatePlayerRanking());
    }

    // Abstract kernel methods to be implemented by concrete subclass

    /**
     * Returns all players currently tracked.
     *
     * @return an iterable collection of player names
     */
    protected abstract Iterable<String> getAllPlayers();

    /**
     * Gets the number of goals for the specified player.
     *
     * @param player
     *            the name of the player
     * @return the number of goals scored
     */
    protected abstract int getGoals(String player);

    /**
     * Gets the number of assists for the specified player.
     *
     * @param player
     *            the name of the player
     * @return the number of assists made
     */
    protected abstract int getAssists(String player);

    /**
     * Gets the number of penalties for the specified player.
     *
     * @param player
     *            the name of the player
     * @return the number of penalties recieved
     */
    protected abstract int getPenalties(String player);

    /**
     * Gets the number of saves for the specified goalie.
     *
     * @param player
     *            the name of the goalie
     * @return the number of saves made
     */
    protected abstract int getSaves(String player);

    /**
     * Gets the number of shots against for the specified goalie.
     *
     * @param player
     *            the name of the goalie
     * @return the number of shots faced
     */
    protected abstract int getShotsAgainst(String player);

}
