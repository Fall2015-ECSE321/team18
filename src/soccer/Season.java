package soccer;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class Season {

	private String uniqueID;
	private String name;
	private League league;
	private SeasonDisplay subscribedSeasonDisplay;
	private List<Match> matches;

	public Season(String name, League league) {
		this.name = name;
		this.league = league;
		matches = new ArrayList<Match>();
		subscribedSeasonDisplay = new SeasonDisplay(matches);
		uniqueID = UUID.randomUUID().toString();
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public String getName() {
		return name;
	}

	public League getLeague() {
		return league;
	}

	public SeasonDisplay getSubscribedSeasonDisplay() {
		return subscribedSeasonDisplay;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public String toString() {
		String returnString = "Season";
		returnString += "\nuniqueID:\t" + uniqueID;
		returnString += "\nname:    \t" + name;
		returnString += "\nleague:  \t" + league;
		returnString += "\nmatches: \t" + matches.size();
		return returnString;
	}

}
