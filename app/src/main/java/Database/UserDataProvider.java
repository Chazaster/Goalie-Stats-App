/* Created by Chase Watson */
package Database;

public class UserDataProvider {
    // Getters and Setters for grabbing user data
    private String name;
    private String number;
    private String team;

    // Getter and Setter for team
    public String getTeam() { return team; }
    public void setTeam (String team) { this.team = team; }

    // Getter and Setter for name
    public String getName() { return name; }
    public void setName (String name) { this.name = name; }

    // Getter and Setter for number
    public String getNumber() { return number; }
    public void setNumber (String number) { this.number = number; }

    public UserDataProvider (String name, String number, String team) {
        this.name = name;
        this.number = number;
        this.team = team;
    }
}
