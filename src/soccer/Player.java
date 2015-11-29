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
	private List<MatchEvent> matchEventsApplied;

	public Player(String firstName, String lastName, int number) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;

		uniqueID = UUID.randomUUID().toString();
		matchEventsApplied = new ArrayList<MatchEvent>();
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public String getFullName() {
		return firstName + " " + lastName;
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

	public List<MatchEvent> getMatchEventsApplied() {
		return matchEventsApplied;
	}

	public String toString() {
		String returnString = "";
		returnString += "\nPlayer:            \t" + getFullName();
		returnString += "\nuniqueID:          \t" + uniqueID;
		returnString += "\nnumber:            \t" + number;
		returnString += "\ngamesPlayed:       \t" + gamesPlayed;
		returnString += "\nshots:             \t" + shots;
		returnString += "\ngoals:             \t" + goals;
		returnString += "\nyellowCards:       \t" + yellowCards;
		returnString += "\nredCards:          \t" + redCards;
		returnString += "\npenaltyKicks:      \t" + penaltyKicks;
		returnString += "\nmatchEventsApplied:\t" + matchEventsApplied.size();
		return returnString;
	}

	public String applyMatchEvent(ShotEvent event) {
		if (matchEventsApplied.contains(event)) {
			return "This ShotEvent has already been published to this player";
		}
		else {
			matchEventsApplied.add(event);
			shots++;
			if (event.getScored()) {
				goals++;
			}
			return "published ShotEvent";
		}
	}

	public String unapplyMatchEvent(ShotEvent event) {
		if (matchEventsApplied.contains(event)) {
			matchEventsApplied.remove(event);
			shots--;
			if (event.getScored()) {
				goals--;
			}
			return "retracted published ShotEvent";
		}
		else {
			return "This ShotEvent has not been published to this player";
		}
	}

	public String applyMatchEvent(InfractionEvent event) {
		if (matchEventsApplied.contains(event)) {
			return "This InfractionEvent has already been published to this player";
		}
		else {
			matchEventsApplied.add(event);
			if (event.getRedCard()) {
				redCards++;
			}
			if (event.getYellowCard()) {
				yellowCards++;
			}
			if (event.getPenaltyKick()) {
				penaltyKicks++;
			}
			return "published ShotEvent";
		}
	}

	public String unapplyMatchEvent(InfractionEvent event) {
		if (matchEventsApplied.contains(event)) {
			matchEventsApplied.remove(event);
			if (event.getRedCard()) {
				redCards--;
			}
			if (event.getYellowCard()) {
				yellowCards--;
			}
			if (event.getPenaltyKick()) {
				penaltyKicks--;
			}
			return "retracted published ShotEvent";
		}
		else {
			return "This InfractionEvent has not been published to this player";
		}
	}

}
