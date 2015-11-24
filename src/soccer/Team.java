package soccer;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
public class Team {

	private String uniqueID;
	private String name;
	private int gamesPlayed;
	private int points;
	private int wins;
	private int losses;
	private int draws;
	private int shots;
	private int goalsFor;
	private int goalsAgainst;
	private int yellowCards;
	private int redCards;
	private int penaltyKicks;
	private List<String> matchResultsApplied;
	private List<Player> players;

	public Team(String name) {
		this.name = name;

		uniqueID = UUID.randomUUID().toString();
		matchResultsApplied = new ArrayList<String>();
		players = new ArrayList<Player>();
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public String getName() {
		return name;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public int getPoints() {
		return points;
	}

	public int getWins() {
		return wins;
	}

	public int getLosses() {
		return losses;
	}

	public int getDraws() {
		return draws;
	}

	public int getShots() {
		return shots;
	}

	public int getGoalsFor() {
		return goalsFor;
	}

	public int getGoalsAgainst() {
		return goalsAgainst;
	}

	public int getRedCards() {
		return redCards;
	}

	public int getYellowCards() {
		return yellowCards;
	}

	public int getPenaltyKicks() {
		return penaltyKicks;
	}

	public List<String> getMatchResultsApplied() {
		return matchResultsApplied;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public String toString() {
		String returnString = "";
		returnString += "\nTeam:\t\t\t" + name ;
		returnString += "\nuniqueID:\t\t\t" + uniqueID ;
		returnString += "\ngamesPlayed:\t\t" + gamesPlayed ;
		returnString += "\npoints:\t\t\t" + shots ;
		returnString += "\nwins:\t\t\t" + wins ;
		returnString += "\nlosses:\t\t\t" + losses ;
		returnString += "\ndraws:\t\t\t" + draws ;
		returnString += "\nshots:\t\t\t" + shots ;
		returnString += "\ngoalsFor:\t\t\t" + goalsFor ;
		returnString += "\ngoalsAgainst:\t\t" + goalsAgainst ;
		returnString += "\nredCards:\t\t\t" + redCards ;
		returnString += "\nyellowCards:\t\t" + yellowCards ;
		returnString += "\npenaltyKicks:\t\t" + penaltyKicks ;
		returnString += "\nmatchResultsApplied:\t" + matchResultsApplied.size() ;
		returnString += "\nplayers:\t\t\t" + players.size() ;
		return returnString;
	}

	public String addPlayer(Player newPlayer) {
		if (players.contains(newPlayer)) {
			return "ERROR; This player already exists on team.";
		}
		else {
			players.add(newPlayer);
			return "Player succesfully added to team.";
		}
	}


	// public String updateTeam(matchResult result) {
	// 	return "";
	// }


}
