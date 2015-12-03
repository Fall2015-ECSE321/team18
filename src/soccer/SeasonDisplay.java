package soccer;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class SeasonDisplay {

	private String uniqueID;
	private String seasonData[][];

	public SeasonDisplay() {
		uniqueID = UUID.randomUUID().toString();
		seasonData = new String[0][0];
	}
	
	public void update(List<Match> matches) {
		seasonData = new String[matches.size()][];
		int count = 0;
		for (Match match : matches) {
			seasonData[count] = match.getMatchData();
			count++;
		}
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public String[][] getSeasonData() {
		return seasonData;
	}

	public String toString() {
		String returnString = "SeasonDisplay";
		return returnString;
	}

}
