package soccer;


/** The Goalie object extends the Player object
 * 
 * @author Team 18
 *
 */
public class Goalie extends Player{

	private int saves;
	private int goalsAllowed;

	/** Constructor method: initialize Goalie 
	 * 
	 * @param firstName		The Goalie's first name
	 * @param lastName		The Goalie's last name
	 * @param number		The Goalie's player number
	 */
	public Goalie(String firstName, String lastName, int number) {
		super(firstName, lastName, number);
	}

	
	public int getSaves() {
		return saves;
	}

	public int getGoalsAllowed() {
		return goalsAllowed;
	}

	/** Converts Goalie statistics to string
	 * 
	 * @see soccer.Player#toString()
	 * 
	 * @return returnString		Lists the Goalie's Player Statistics, as well as the type of Statistic
	 */
	
	public String toString() {
		String returnString = "";
		returnString += super.toString();
		returnString += "\nsaves:             \t" + saves;
		returnString += "\ngoalsAllowed:      \t" + goalsAllowed;
		return returnString;
	}

	/** Converts a ShotEvent into Goalie statistics
	 * 
	 * @see soccer.Player#applyMatchEvent(soccer.ShotEvent)
	 * 
	 * @param event		A ShotEvent Object describing a shot on net
	 * 
	 * @return			Returns a String for whether a method succeeded or not
	 */
	public String applyMatchEvent(ShotEvent event) {
		if (this == event.getSubscribedGoalie()) {
			if (super.getMatchEventsApplied().contains(event)) {
				return "This ShotEvent has already been published to this goalie";
			}
			else {
				super.getMatchEventsApplied().add(event);
				if (event.getScored()) {
					goalsAllowed++;
				}
				else {
					saves++;
				}
				return "published ShotEvent";
			}
		}
		else {
			return super.applyMatchEvent(event);
		}
	}

	/** Removes ShotEvent from Goalie statistics
	 * 
	 * @see soccer.Player#unapplyMatchEvent(soccer.ShotEvent)
	 * 
	 * @param event		A ShotEvent Object describing a shot on net
	 * 
	 * @return			Returns a String for whether a method succeeded or not
	 */
	public String unapplyMatchEvent(ShotEvent event) {
		if (this == event.getSubscribedGoalie()) {
			if (super.getMatchEventsApplied().contains(event)) {
				super.getMatchEventsApplied().remove(event);
				if (event.getScored()) {
					goalsAllowed--;
				}
				else {
					saves--;
				}
				return "published ShotEvent";
			}
			else {
				return "This ShotEvent has not been published to this goalie";
			}
		} 
		else {
			return super.unapplyMatchEvent(event);
		}
	}


}
