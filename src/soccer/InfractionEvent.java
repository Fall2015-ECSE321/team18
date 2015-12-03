package soccer;

/** Models an infraction taking place in a Match
 * @author Team 18
 *
 */
public class InfractionEvent extends MatchEvent{

	private boolean redCard;
	private boolean yellowCard;
	private boolean penaltyKick;

	/** Constructor method, sets a unique ID to the event
	 * @see soccer.MatchEvent#MatchEvent()
	 */
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

	/** Indicates if InfractionEvent involves a red card
	 * 
	 * @param redCard		Set to true if red card is issued, false otherwise
	 * @return				Returns a String for whether the method succeeded or not
	 */
	public String setRedCard(boolean redCard) {
		this.redCard = redCard;
		return "RedCard boolean succesfully set to " + this.redCard + ".";
	}
	
	/** Indicates if InfractionEvent involves a yellow card
	 * 
	 * @param yellowCard	Set to true if yellow card is issued, false otherwise
	 * @return				Returns a String for whether the method succeeded or not
	 */
	public String setYellowCard(boolean yellowCard) {
		this.yellowCard = yellowCard;
		return "YellowCard boolean succesfully set to " + this.yellowCard + ".";
	}
	
	/** Indicates if InfractionEvent involves a penalty kick
	 * 
	 * @param penaltyKick	Set to true if penalty kick is issued, false otherwise
	 * @return				Returns a String for whether the method succeeded or not
	 */
	public String setPenaltyKick(boolean penaltyKick) {
		this.penaltyKick = penaltyKick;
		return "penaltyKick boolean succesfully set to " + this.penaltyKick + ".";
	}

	/** Publishes match event and indicates players to update
	 * 
	 * @see 		soccer.MatchEvent#publishMatchEvent()
	 * @return		Returns a String for whether the method succeeded or not
	 */
	public String publishMatchEvent() {
		if (super.getSubscribedPlayer() != null) {
			super.getSubscribedPlayer().applyMatchEvent(this);
			return "InfractionEvent was published";
		}
		else {
			return "InfractionEvent was not published";
		}
	}

	/** Indicates players to removed update caused by this match event
	 * 
	 * @see 		soccer.MatchEvent#unpublishMatchEvent()
	 * @return 		Returns a String for whether the method succeeded or not
	 */
	public String unpublishMatchEvent() {
		if (super.getSubscribedPlayer() != null) {
			super.getSubscribedPlayer().unapplyMatchEvent(this);
			return "InfractionEvent was unpublished";
		}
		else {
			return "InfractionEvent remained published";
		}
	}

	/** Lists InfractionEvent fields as string
	 * 
	 * @see 	soccer.MatchEvent#toString()
	 * @return 	returnString	Returns a string listing the event ID, player's full name, and infractions involved		
	 */
	public String toString() {
		String returnString = "\nInfractionEvent:";
		returnString += super.toString();
		returnString += "\nRedCard:    \t" + redCard;
		returnString += "\nYellowCard: \t" + yellowCard;
		returnString += "\nPenaltyKick:\t" + penaltyKick;
		return returnString;
	}
	
	public String getSummary() {
		String summaryString = "";
		summaryString += super.getSubscribedPlayer().getTeamName() + " player " + super.getSubscribedPlayer().getFullName();
		summaryString += " received the following infractions: ";
		if (redCard) {summaryString += " red card ";}
		if (yellowCard) {summaryString += " yellow card ";}
		if (penaltyKick) {summaryString += " penalty kick ";}
		return summaryString;
	}

}
