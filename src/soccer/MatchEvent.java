package soccer;

import java.util.UUID;

abstract public class MatchEvent {

	private String uniqueID;
	private Player subscribedPlayer;

	public 	MatchEvent() {
		uniqueID = UUID.randomUUID().toString(); 
	}

	public Player getSubscribedPlayer() {
		return subscribedPlayer;
	}

	public String setSubscribedPlayer(Player newPlayer) {
		subscribedPlayer = newPlayer;
		return "Player " + subscribedPlayer.getFullName() + " succesfully subscribed to MatchEvent.";
	}

	abstract public String publishMatchEvent();

	abstract public String unpublishMatchEvent();

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
