package soccer;

import java.util.UUID;

abstract public class MatchEvent {

	private String uniqueID;
	private Player subscribedPlayer;

	public 	MatchEvent() {
		uniqueID = UUID.randomUUID().toString(); 
	}

	public Player getPlayer() {
		return subscribedPlayer;
	}

	public String setPlayer(Player newPlayer) {
		subscribedPlayer = newPlayer;
		return "Player " + subscribedPlayer.getFullName() + " succesfully subscribed to MatchEvent.";
	}

	abstract public String publishMatchEvent();

	public String toString() {
		String returnString = "";
		returnString += "\nuniqueID:\t" + uniqueID ;
		returnString += "\nPlayer:  \t" + subscribedPlayer.getFullName();
		return returnString;
	}

}
