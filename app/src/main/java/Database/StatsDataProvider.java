/* Created by Chase Watson */
package Database;

public class StatsDataProvider {
    // Getters and Setters for grabbing stats data
    private String saves;
    private String shots_against;
    private String goals_against;
    private String save_percentage;
    private String goals_against_avg;

    // Getter and Setter for saves
    public String getSaves() { return saves; }
    public void setSaves (String saves) { this.saves = saves; }

    // Getter and Setter for shots_against
    public String getShotsAgainst() { return shots_against; }
    public void setShotsAgainst (String shots_against) { this.shots_against = shots_against; }

    // Getter and Setter for goals_against
    public String getGoalsAgainst() { return goals_against; }
    public void setGoalsAgainst (String goals_against) { this.goals_against = goals_against; }

    // Getter and Setter for save_percentage
    public String getSavePercentage() { return save_percentage; }
    public void setSavePercentage (String save_percentage) { this.save_percentage = save_percentage; }

    // Getter and Setter for goals_against_avg
    public String getGoalsAgainstAvg() { return goals_against_avg; }
    public void setGoalsAgainstAvg (String goals_against_avg) { this.goals_against_avg = goals_against_avg; }

    public StatsDataProvider (String saves, String shots_against, String goals_against, String save_percentage, String goals_against_avg) {
        this.saves = saves;
        this.shots_against = shots_against;
        this.goals_against = goals_against;
        this.save_percentage = save_percentage;
        this.goals_against_avg = goals_against_avg;
    }
}
