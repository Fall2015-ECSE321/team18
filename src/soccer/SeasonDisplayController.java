package soccer;

import java.util.Arrays;

import persistence.PersistenceXStream;

public class SeasonDisplayController {

	public static String[][] getSeasonDataRows(Season season) {
		season.getLeague().publishRankings();
		String[][] seasonDataRows = season.getSubscribedSeasonDisplay().getSeasonData();
		//System.out.println(Arrays.deepToString(seasonDataRows));
		return seasonDataRows;
	}
			
	
	public static String[] getSeasonDataHeaders() {
		String seasonDataHeaders[] = { "HomeTeam",
									   "RCrd",
									   "YCrd",
									   "PK",
									   "Sh",
									   "Pts",
									   "",
									   "Pts",
									   "Sh",
									   "PK",
									   "YCrd",
									   "RCrd",
									   "AwayTeam",
									   "Date",
									   "Time"};
		return seasonDataHeaders;
	}
}