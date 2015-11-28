package soccer;

public class InfractionEvent {

	private boolean redCard;
	private boolean yellowCard;
	private boolean penaltyKick;

	public 	InfractionEvent() {
		super();
	}

	public boolean getRedCard() {
		return redCard;
	}

	public boolean getYellowCard() {
		return yellowCard;
	}

	public boolean getPenaltyKick() {
		return penaltyKick;
	}

	public String setRedCard(boolean redCard) {
		this.redCard = redCard;
		return "RedCard boolean succesfully set to " + this.redCard + ".";
	}

	public String setYellowCard(boolean yellowCard) {
		this.yellowCard = yellowCard;
		return "YellowCard boolean succesfully set to " + this.yellowCard + ".";
	}

	public String setPenaltyKick(boolean penaltyKick) {
		this.penaltyKick = penaltyKick;
		return "penaltyKick boolean succesfully set to " + this.penaltyKick + ".";
	}

	public String publishMatchEvent() {
		return "published";
	}

	public String toString() {
		String returnString = "\nInfractionEvent:";
		returnString += super.toString();
		returnString += "\nRedCard:  \t" + redCard;
		returnString += "\nYellowCard:  \t" + yellowCard;
		returnString += "\nPenaltyKick:  \t" + penaltyKick;
		return returnString;
	}

}
