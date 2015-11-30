package soccer;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class SeasonDisplay {

	private String uniqueID;
	private List<Match> matches;

	public SeasonDisplay(List<Match> matches) {
		uniqueID = UUID.randomUUID().toString();
		this.matches = new ArrayList<Match>();
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public String toString() {
		String returnString = "SeasonDisplay";
		return returnString;
	}

}
