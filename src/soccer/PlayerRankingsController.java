package soccer;

import java.util.Arrays;


import persistence.PersistenceXStream;

public class PlayerRankingsController {


	public static String[][] generatePlayerDataRows(Season season) {
		season.getLeague().publishRankings();
		String[][] playerDataRows = season.getLeague().getSubscribedPlayerRankings().getPlayerData();
		//System.out.println(Arrays.deepToString(playerDataRows));
		return playerDataRows;
	}
			
	
	public static String[] getPlayerDataHeaders() {
		String playerDataHeaders[] = { "FirstName",
									   "LastName",
									   "Number",
									   "GP",
									   "Sh",
									   "G",
									   "RCrd",
									   "YCrd",
									   "PK"};
		return playerDataHeaders;
	}
}
			
