package soccer;

/** This class extends a MatchEvent and describes a shot event. It has same
 * fields as a MatchEvent as well as a subscribedGoalie and scored field.
 * 
 * @author Team 18
 *
 */
public class ShotEvent extends MatchEvent{

	private Goalie subscribedGoalie;
	private boolean scored;

	/** Constructor method. Assigns unique ID to ShotEvent. 
	 * 
	 */
	public 	ShotEvent() {
		super();
	}
	// getters and setters
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

	/** This method publishes match event and indicates players to update.
	 * 
	 * @see soccer.MatchEvent#publishMatchEvent()
	 * @return		Returns String indicating whether the ShotEvent was published
	 * 				or not.
	 */
	public String publishMatchEvent() {
		if (super.getSubscribedPlayer() != null && subscribedGoalie != null) {
			super.getSubscribedPlayer().applyMatchEvent(this);
			subscribedGoalie.applyMatchEvent(this);
			return "ShotEvent was published";
		}
		else {
			return "ShotEvent was not published";
		}
	}

	/** This method unpublishes match event and indicates players to update.
	 * @see soccer.MatchEvent#unpublishMatchEvent()
	 * 
	 * @return 		Returns a String indicating whether or not ShotEvent was unpublished.
	 */
	public String unpublishMatchEvent() {
		if (super.getSubscribedPlayer() != null && subscribedGoalie != null) {
			super.getSubscribedPlayer().unapplyMatchEvent(this);
			subscribedGoalie.unapplyMatchEvent(this);
			return "ShotEvent was unpublished";
		}
		else {
			return "ShotEvent remained published";
		}
	}

	/** This method lists all the ShotEvent fields and their values.  
	 * @see soccer.MatchEvent#toString()
	 * @return		Returns a String listing the ShotEvent subscribedGoalie
	 * 				and scored boolean value.
	 */
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
	
	public String getSummary() {
		String summaryString = "";
		summaryString += super.getSubscribedPlayer().getTeamName() + " player " + super.getSubscribedPlayer().getFullName();
		if (scored) {
			summaryString += " took shot and scored on ";
		}
		else {
			summaryString += " took shot which was saved by ";
		}
		summaryString += subscribedGoalie.getTeamName() + " goalie " + subscribedGoalie.getFullName();
		
		
		return summaryString;
	}

}
