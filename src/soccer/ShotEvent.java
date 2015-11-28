package soccer;

public class ShotEvent {

	private Goalie subscribedGoalie;
	private boolean scored;

	public 	ShotEvent() {
		super();
	}

	public Goalie getGoalie() {
		return subscribedGoalie;
	}

	public String setGoalie(Goalie newGoalie) {
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
		return "published";
	}

	public String toString() {
		String returnString = "\nShotEvent:";
		returnString += super.toString();
		returnString += "\nGoalie:  \t" + subscribedGoalie.getFullName();
		returnString += "\nScored:  \t" + scored ;
		return returnString;
	}

}
