package soccer;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

/** This class keeps track of a Player's attributes. Attributes include
 * a uniqueID, his/her first name, last name, number, games played, shots on net,
 * goals, red cards, yellow cards, penalty kicks, and involved MatchEvents.
 * 
 * @author Team 18
 *
 */
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

	/** Constructor method. Initialized the fields and sets a unique ID.
	 * 
	 * @param firstName		The player's first name.
	 * @param lastName		The player's last name.
	 * @param number		The player's number.
	 */
	public Player(String firstName, String lastName, int number) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;

		uniqueID = UUID.randomUUID().toString();
		matchEventsApplied = new ArrayList<MatchEvent>();
	}

	// getters
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

	/** This method lists all the player attributes: name; uniqueID;
	 * 	number; gamesPlayed; shots; goals; yellowCards; redCards;
	 * 	penaltyKicks; matchEventsApplied.
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * @return 		Returns a String listing all the player fields and their values.
	 */
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

	/**	This method takes a ShotEvent and adds it to the matchEventsApplied list.
	 * At the same time, it updates the player's shots and goals fields.
	 * 
	 * @param event		The ShotEvent involving the player.
	 * @return			Returns a String indicating whether the event was published
	 * 					or not.
	 */
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

	/** This method takes a ShotEvent and remove it from the matchEventsApplied list if
	 * it exists in the list. At the same time, it updates the player's shots and goals fields
	 * if necessary.
	 * 
	 * @param event		The ShotEvent intended to be removed.
	 * @return			Returns a String indicating whether the event was unpublished
	 * 					or not.
	 */
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

	/** This method takes an InfractionEvent and adds it to the matchEventsApplied list.
	 * At the same time, it updates the player's redCards, yellowCards and penaltyKicks
	 * fields.
	 * 
	 * @param event		The InfractionEvent involving the player.
	 * @return			Returns a String indicating whether the InfractionEvent has
	 * 					been published or not.
	 */
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
			return "published InfractionEvent";
		}
	}

	/** This method takes an InfractionEvent and removes it from the matchEventsApplied list.
	 * At the same time, it updates the player's redCards, yellowCards and penaltyKicks
	 * fields if necessary.
	 * 
	 * @param event		The InfractionEvent involving the player.
	 * @return			Returns a String indicating whether the InfractionEvent has
	 * 					been unpublished or not.
	 */
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
