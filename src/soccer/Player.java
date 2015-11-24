package soccer;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
public class Player {

	private String uniqueID;
	private String firstName;
	private String lastName;
	private int number;
	private int gamesPlayed;
	private int shots;
	private int goals;
	private int redCards;
	private int yellowCards;
	private int penaltyKicks;
	private List<String> matchEventsApplied;

	public Player(String firstName, String lastName, int number) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;

		uniqueID = UUID.randomUUID().toString();
		matchEventsApplied = new ArrayList<String>();
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getNumber() {
		return number;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public int getShots() {
		return shots;
	}

	public int getGoals() {
		return goals;
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

	public List<String> getMatchEventsApplied() {
		return matchEventsApplied;
	}

	public String toString() {
		String returnString = "";
		returnString += "\nPlayer:\t\t" + firstName + " " + lastName ;
		returnString += "\nuniqueID:\t\t" + uniqueID ;
		returnString += "\nnumber:\t\t" + number ;
		returnString += "\ngamesPlayed:\t" + gamesPlayed ;
		returnString += "\nshots:\t\t" + shots ;
		returnString += "\ngoals:\t\t" + goals ;
		returnString += "\nyellowCards:\t" + yellowCards ;
		returnString += "\nredCards:\t\t" + redCards ;
		returnString += "\npenaltyKicks:\t" + penaltyKicks ;
		returnString += "\nmatchEventsApplied:\t" + matchEventsApplied.size() ;
		return returnString;
	}

	// public String updatePlayer(playerShot shotEvent) {
	// 	return "";
	// }

	// public String updatePlayer(playerInfraction infractionEvent) {
	// 	return "";
	// }

}
