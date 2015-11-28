package soccer;

import java.util.UUID;

public class Match {

	private String uniqueID;
	private Team subscribedHomeTeam;
	private Team subscribedAwayTeam;

	public 	Match() {
		uniqueID = UUID.randomUUID().toString(); 
	}

	public Team getSubscribedHomeTeam() {
		return subscribedHomeTeam;
	}

	public Team getSubscribedAwayTeam() {
		return subscribedAwayTeam;
	}

	public String setSubscribedHomeTeam(Team homeTeam) {
		subscribedHomeTeam = homeTeam;
		return "HomeTeam " + subscribedHomeTeam.getName() + " succesfully subscribed to Match.";
	}

	public String setSubscribedAwayTeam(Team awayTeam) {
		subscribedAwayTeam = awayTeam;
		return "AwayTeam " + subscribedAwayTeam.getName() + " succesfully subscribed to Match.";
	}

	public String toString() {
		String returnString = "";
		returnString += "\nuniqueID: \t" + uniqueID ;
		if (subscribedHomeTeam != null) {
			returnString += "\nHomeTeam: \t" + subscribedHomeTeam.getName();
		}
		else {
			returnString += "\nHomeTeam: \tNot set";
		}
		if (subscribedAwayTeam != null) {
			returnString += "\nAwayTeam: \t" + subscribedAwayTeam.getName();
		}
		else {
			returnString += "\nAwayTeam: \tNot set";
		}
		return returnString;
	}

}
