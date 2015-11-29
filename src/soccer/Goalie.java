package soccer;

public class Goalie extends Player{

	private int saves;
	private int goalsAllowed;

	public Goalie(String firstName, String lastName, int number) {
		super(firstName, lastName, number);
	}

	public int getSaves() {
		return saves;
	}

	public int getGoalsAllowed() {
		return goalsAllowed;
	}

	public String toString() {
		String returnString = "";
		returnString += super.toString();
		returnString += "\nsaves:             \t" + saves;
		returnString += "\ngoalsAllowed:      \t" + goalsAllowed;
		return returnString;
	}

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
