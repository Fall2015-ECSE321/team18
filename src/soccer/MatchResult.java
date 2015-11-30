package soccer;

import java.util.UUID;

public class MatchResult {

	private String uniqueID;
	private int homePoints;
	private int homeShots;
	private int homeYellowCards;
	private int homeRedCards;
	private int homePenaltyKicks;
	private int awayPoints;
	private int awayShots;
	private int awayYellowCards;
	private int awayRedCards;
	private int awayPenaltyKicks;


	public 	MatchResult() {
		uniqueID = UUID.randomUUID().toString(); 
		homePoints = 0;
		homeShots = 0;
		homeYellowCards = 0;
		homeRedCards = 0;
		homePenaltyKicks = 0;
		awayPoints = 0;
		awayShots = 0;
		awayYellowCards = 0;
		awayRedCards = 0;
		awayPenaltyKicks = 0;
	}


	public int getPoints(boolean isHomeTeam) {
		if (isHomeTeam) {
			return homePoints;
		}
		else {
			return awayPoints;
		}
	}

	public int getShots(boolean isHomeTeam) {
		if (isHomeTeam) {
			return homeShots;
		}
		else {
			return awayShots;
		}
	}

	public int getYellowCards(boolean isHomeTeam) {
		if (isHomeTeam) {
			return homeYellowCards;
		}
		else {
			return awayYellowCards;
		}
	}

	public int getRedCards(boolean isHomeTeam) {
		if (isHomeTeam) {
			return homeRedCards;
		}
		else {
			return awayRedCards;
		}
	}
	
	public int getPenaltyKicks(boolean isHomeTeam) {
		if (isHomeTeam) {
			return homePenaltyKicks;
		}
		else {
			return awayPenaltyKicks;
		}
	}




	public String applyEvent(int team, ShotEvent event) {
		if (team == 0) {
			homeShots++;
			if (event.getScored()) {
				homePoints++;
			}
		}
		else {
			awayShots++;
			if (event.getScored()) {
				awayPoints++;
			}
		}
		return "applied ShotEvent to MatchResult";
	}

	public String applyEvent(int team, InfractionEvent event) {
		if (team == 0) {
			if (event.getRedCard()) {
				homeRedCards++;
			}
			if (event.getYellowCard()) {
				homeYellowCards++;
			}
			if (event.getPenaltyKick()) {
				homePenaltyKicks++;
			}
		}
		else {
			if (event.getRedCard()) {
				awayRedCards++;
			}
			if (event.getYellowCard()) {
				awayYellowCards++;
			}
			if (event.getPenaltyKick()) {
				awayPenaltyKicks++;
			}
		}
		return "applied InfractionEvent to MatchResult";
	}

	public String unapplyEvent(int team, ShotEvent event) {
		if (team == 0) {
			homeShots--;
			if (event.getScored()) {
				homePoints--;
			}
		}
		else {
			awayShots--;
			if (event.getScored()) {
				awayPoints--;
			}
		}
		return "removed ShotEvent from MatchResult";
	}

	public String unapplyEvent(int team, InfractionEvent event) {
		if (team == 0) {
			if (event.getRedCard()) {
				homeRedCards--;
			}
			if (event.getYellowCard()) {
				homeYellowCards--;
			}
			if (event.getPenaltyKick()) {
				homePenaltyKicks--;
			}
		}
		else {
			if (event.getRedCard()) {
				awayRedCards--;
			}
			if (event.getYellowCard()) {
				awayYellowCards--;
			}
			if (event.getPenaltyKick()) {
				awayPenaltyKicks--;
			}
		}
		return "removed InfractionEvent from MatchResult";
	}



	

	public String toString() {
		String returnString = "\nMatchResult:";
		returnString += "\nuniqueID:        \t" + uniqueID;
		returnString += "\nhomePoints:      \t" + homePoints;
		returnString += "\nhomeShots:       \t" + homeShots;
		returnString += "\nhomeYellowCards: \t" + homeYellowCards;
		returnString += "\nhomeRedCards:    \t" + homeRedCards;
		returnString += "\nhomePenaltyKicks:\t" + homePenaltyKicks;
		returnString += "\nawayPoints:      \t" + awayPoints;
		returnString += "\nawayShots:       \t" + awayShots;
		returnString += "\nawayYellowCards: \t" + awayYellowCards;
		returnString += "\nawayRedCards:    \t" + awayRedCards;
		returnString += "\nawayPenaltyKicks:\t" + awayPenaltyKicks;
		return returnString;
	}

}
