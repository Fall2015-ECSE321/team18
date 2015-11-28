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

	// public String updatePlayer(playerShot shotEvent) {
	// 	return "";
	// }

	// public String updatePlayer(playerInfraction infractionEvent) {
	// 	return "";
	// }

}
