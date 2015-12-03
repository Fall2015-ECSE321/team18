package soccer;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;


/** This class contains private fields belonging to a League as well as methods
 * that would modify the League.
 * 
 * @author Team 18
 *
 */
public class League {

	private String uniqueID;
	private String name;
	private TeamRankings subscribedTeamRankings;
	private PlayerRankings subscribedPlayerRankings;
	private List<Team> teams;

	/** Constructor method; sets League name and gives it a unique ID.
	 * 
	 * @param name		Intended League name
	 */
	public League(String name) {
		this.name = name;

		uniqueID = UUID.randomUUID().toString();
		teams = new ArrayList<Team>();
		subscribedTeamRankings = new TeamRankings();
		subscribedPlayerRankings = new PlayerRankings();
		publishRankings();
	}

	// getters
	public String getUniqueID() {
		return uniqueID;
	}

	public String getName() {
		return name;
	}

	public List<Team> getTeams() {
		return teams;
	}


	/** Lists the League's fields as string. Fields include the League name,
	 * its unique ID, and the number of teams currently registered in the League.
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * @return		returns a list of the League's fields
	 */
	public String toString() {
		String returnString = "";
		returnString += "\nLeague:  \t\t" + name ;
		returnString += "\nuniqueID:\t\t" + uniqueID ;
		returnString += "\nteams:   \t\t" + teams.size() ;
		return returnString;
	}

	/** Registers a team into the League. 
	 * @param newTeam	The intended team name to be added in the league
	 * @return			Returns a string to indicate whether the method succeeded or not 
	 */
	public String addTeam(Team newTeam) {
		if (teams.contains(newTeam)) {
			return "ERROR; This team already exists in League.";
		}
		else {
			teams.add(newTeam);
			return "Team succesfully added to League.";
		}
	}

	/**	Not yet implemented
	 * @return
	 */
	public void publishRankings() {
		subscribedTeamRankings.update(teams);
		subscribedPlayerRankings.update(teams);
	}

	public TeamRankings getSubscribedTeamRankings() {
		return subscribedTeamRankings;
	}
	
	public PlayerRankings getSubscribedPlayerRankings() {
		return subscribedPlayerRankings;
	}


}
