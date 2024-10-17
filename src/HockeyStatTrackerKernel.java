//Nick Challingsworth
//Challingsworth.1

import components.standard.Standard;

public interface HockeyStatTrackerKernel
        extends Standard<HockeyStatTrackerPOF> {

    /**
     * Adds player stats including goals, assists, and penalties.
     *
     * @param player
     *            the name of the player
     * @param goals
     *            number of goals scored
     * @param assists
     *            number of assists made
     * @param penalties
     *            number of penalties incurred
     * @ensures player stats are updated or initialized with the given stats
     */
    void addPlayerStats(String player, int goals, int assists, int penalties);

    /**
     * Adds goalie stats including saves and shots against.
     *
     * @param player
     *            the name of the goalie
     * @param saves
     *            number of saves made
     * @param shotsAgainst
     *            number of shots faced
     * @ensures goalie stats are updated or initialized with the given stats
     */
    void addGoalieStats(String player, int saves, int shotsAgainst);

    /**
     * Gets the total number of goals scored by a team.
     *
     * @param team
     *            the name of the team
     * @return the total goals scored by the team
     * @ensures returns a non-negative integer representing goals
     */
    int getTeamGoals(String team);
}
