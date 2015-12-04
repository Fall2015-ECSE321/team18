package soccer;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import persistence.PersistenceXStream;

public class LiveInputController {


	public static JTable generateMatchEventsTable(Match liveMatch) {
		String[] matchEventsHeader = {"timestamp", "Match Events Feed"};
		JTable matchEventsTable = new JTable(liveMatch.getMatchEventsSummary(), matchEventsHeader);
		return matchEventsTable;
	}


	public static Match newMatch(Team homeTeam, Team awayTeam, Season season) {
		//Season season = (soccer.Season) PersistenceXStream.loadFromXMLwithXStream();
		//League league
		//System.out.println(season.getMatches().toString());
		Match newMatch = new Match(season, homeTeam, awayTeam);
		season.addMatch(newMatch);
		//System.out.println(season.getMatches().toString());
		//season.publishSeason();
		return newMatch;
		
	}

	public static Team[] getTeamsArray(Season season) {
		//Season season = (soccer.Season) PersistenceXStream.loadFromXMLwithXStream();
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

	public static Match[] getLiveMatchesArray(Season season) {
		//Season season = (soccer.Season) PersistenceXStream.loadFromXMLwithXStream();
		List<Match> matches = season.getMatches();
		List<Match> liveMatches = new ArrayList<Match>();
		//int count = 0;
		for (Match match : matches) {
			if (!match.getComplete()) {
				liveMatches.add(match);
			}
			//count++;
		}
		return liveMatches.toArray(new Match[liveMatches.size()]);
	}

	public static void endMatch(Match liveMatch) {
		liveMatch.endMatch();
	}
	
	public static Player[] getPlayersArray(Team homeTeam) {
		List<Player> players = homeTeam.getPlayers();
		return players.toArray(new Player[players.size()]);
	}
	
//	public static Team getTeam(Team selectedTeam, Season season) {
//		List<Team> teams = season.getLeague().getTeams();
//		//int count = 0;
//		for (Team team : teams) {
//			if (team.getUniqueID() == selectedTeam.getUniqueID()) {
//				return team;
//			}
//			//count++;
//		}
//		return selectedTeam;
//	}

	public static Player[] getGoaliesArray(Team homeTeam) {
		List<Player> players = homeTeam.getPlayers();
		List<Goalie> goalies = new ArrayList<Goalie>();
		//int count = 0;
		for (Player player : players) {
			if (player instanceof Goalie) {
				goalies.add((Goalie)player);
			}
			//count++;
		}
		return goalies.toArray(new Goalie[goalies.size()]);
	}
}

