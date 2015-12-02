package soccer;

import java.util.UUID;

/** Abstract class representing a MatchEvent. Each MatchEvent is assigned a uniqueID
 * and a player involved in the event.
 * @author Team 18
 *
 */
abstract public class MatchEvent {

	private String uniqueID;
	private Player subscribedPlayer;

	/** Constructor method. Sets a unique ID to MatchEvent.
	 * 
	 */
	public 	MatchEvent() {
		uniqueID = UUID.randomUUID().toString(); 
	}

	// Getters and setters
	public Player getSubscribedPlayer() {
		return subscribedPlayer;
	}

	public String setSubscribedPlayer(Player newPlayer) {
		subscribedPlayer = newPlayer;
		return "Player " + subscribedPlayer.getFullName() + " succesfully subscribed to MatchEvent.";
	}
	
	/** Abstract method to be implemented in subclasses. It is intended to publish
	 * MatchEvent information to the Player objects involved in the event.
	 * 
	 * @return		Returns a string indicating whether the event was published or not.
	 */
	abstract public String publishMatchEvent();

	/** Abstract method to be implemented in subclasses. It is intended to unpublish
	 * MatchEvent information that sent to the Player objects associated with the event.
	 * 
	 * @return		Returns a string indicating whether the event was unpublished or not.
	 */
	abstract public String unpublishMatchEvent();

	/** This method lists the MatchEvent's uniqueID and subscribedPlayer.
	 * 
	 * @see java.lang.Object#toString()
	 * @return 			Returns a string listing the MatchEvent fields and their value.
	 */
	public String toString() {
		String returnString = "";
		returnString += "\nuniqueID:   \t" + uniqueID ;
		if (subscribedPlayer != null) {
			returnString += "\nPlayer:     \t" + subscribedPlayer.getFullName();
		}
		else {
			returnString += "\nPlayer:     \tNot set";
		}
		return returnString;
	}

}
