package soccer;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
public class League {

	private String uniqueID;
	private String name;
	//private teamRanking teamRankingSubscriber;
	//private playerRanking playerRankingSubscriber;
	private List<Team> teams;

	public League(String name) {
		this.name = name;

		uniqueID = UUID.randomUUID().toString();
		teams = new ArrayList<Team>();
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public String getName() {
		return name;
	}

	public List<Team> getTeams() {
		return teams;
	}


	public String toString() {
		String returnString = "";
		returnString += "\nLeague:  \t\t" + name ;
		returnString += "\nuniqueID:\t\t" + uniqueID ;
		returnString += "\nteams:   \t\t" + teams.size() ;
		return returnString;
	}

	public String addTeam(Team newTeam) {
		if (teams.contains(newTeam)) {
			return "ERROR; This team already exists in League.";
		}
		else {
			teams.add(newTeam);
			return "Team succesfully added to League.";
		}
	}

	public String publishToRankings() {
		return "";
	}


}
