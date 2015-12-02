package soccer;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import persistence.PersistenceXStream;

public class LiveInputController {


	// public JTable generateSeasonDataTable() {
	// 	Season season = (soccer.Season) PersistenceXStream.loadFromXMLwithXStream();
	// 	String[][] seasonDataRows = season.getSubscribedSeasonDisplay().getSeasonData();

	// 	String seasonDataHeaders[] = { "HomeTeam",
	// 								   "RCrd",
	// 								   "YCrd",
	// 								   "PK",
	// 								   "Sh",
	// 								   "Pts",
	// 								   "",
	// 								   "Pts",
	// 								   "Sh",
	// 								   "PK",
	// 								   "YCrd",
	// 								   "RCrd",
	// 								   "AwayTeam"};
	// 	JTable seasonDataTable = new JTable(seasonDataRows, seasonDataHeaders);
	// 	return seasonDataTable;
	// }


	public static Match newMatch(Team homeTeam, Team awayTeam) {
		Season season = (soccer.Season) PersistenceXStream.loadFromXMLwithXStream();
		System.out.println(season.getMatches().toString());
		Match newMatch = new Match(season, homeTeam, awayTeam);
		season.addMatch(newMatch);
		System.out.println(season.getMatches().toString());
		//PersistenceXStream.saveToXMLwithXStream(season);
		return newMatch;
		
	}

	public static Team[] getTeamsArray() {
		Season season = (soccer.Season) PersistenceXStream.loadFromXMLwithXStream();
		List<Team> teamsList = season.getLeague().getTeams();
		return teamsList.toArray(new Team[teamsList.size()]);
//		Team[] teamsArray = new Team[teamsList.size()];
//		int count = 0;
//		for (Team team : teamsList) {
//			teamsArray[count] = team;
//			count++;
//		}
//		return teamsArray;
	}

	public static Match[] getLiveMatchesArray() {
		Season season = (soccer.Season) PersistenceXStream.loadFromXMLwithXStream();
		List<Match> matches = season.getMatches();
		List<Match> liveMatches = new ArrayList<Match>();
		int count = 0;
		for (Match match : matches) {
			if (!match.getComplete()) {
				liveMatches.add(match);
			}
			count++;
		}
		return liveMatches.toArray(new Match[liveMatches.size()]);
	}

	public static void endMatch(Match liveMatch) {
		liveMatch.endMatch();
	}
}

