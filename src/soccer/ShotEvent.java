package soccer;

public class ShotEvent extends MatchEvent{

	private Goalie subscribedGoalie;
	private boolean scored;

	public 	ShotEvent() {
		super();
	}

	public Goalie getSubscribedGoalie() {
		return subscribedGoalie;
	}

	public String setSubscribedGoalie(Goalie newGoalie) {
		subscribedGoalie = newGoalie;
		return "Goalie " + subscribedGoalie.getFullName() + " succesfully subscribed to MatchEvent.";
	}

	public boolean getScored() {
		return scored;
	}

	public String setScored(boolean scored) {
		this.scored = scored;
		return "Scored boolean succesfully set to " + this.scored + ".";
	}

	public String publishMatchEvent() {
		if (super.getSubscribedPlayer() != null && subscribedGoalie != null) {
			super.getSubscribedPlayer().updatePlayer(this);
			subscribedGoalie.updateGoalie(this);
			return "ShotEvent was published";
		}
		else {
			return "ShotEvent was not published";
		}
	}

	public String unpublishMatchEvent() {
		if (super.getSubscribedPlayer() != null && subscribedGoalie != null) {
			super.getSubscribedPlayer().revertUpdatePlayer(this);
			subscribedGoalie.revertUpdateGoalie(this);
			return "ShotEvent was unpublished";
		}
		else {
			return "ShotEvent remained published";
		}
	}

	public String toString() {
		String returnString = "\nShotEvent:";
		returnString += super.toString();
		if (subscribedGoalie != null) {
			returnString += "\nGoalie:     \t" + subscribedGoalie.getFullName();
		}
		else {
			returnString += "\nGoalie:     \tNot set";
		}
		returnString += "\nScored:     \t" + scored ;
		return returnString;
	}

}
