package soccer;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class Team {

	private String uniqueID;
	private String name;
	private int gamesPlayed;
	private int points;
	private int wins;
	private int losses;
	private int draws;
	private int shotsFor;
	private int shotsAgainst;
	private int goalsFor;
	private int goalsAgainst;
	private int yellowCards;
	private int redCards;
	private int penaltyKicks;
	private List<MatchResult> matchResultsApplied;
	private List<Player> players;

	public Team(String name) {
		this.name = name;

		uniqueID = UUID.randomUUID().toString();
		matchResultsApplied = new ArrayList<MatchResult>();
		players = new ArrayList<Player>();
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public String getName() {
		return name;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public int getPoints() {
		return points;
	}

	public int getWins() {
		return wins;
	}

	public int getLosses() {
		return losses;
	}

	public int getDraws() {
		return draws;
	}

	public int getShotsFor() {
		return shotsFor;
	}

	public int getShotsAgainst() {
		return shotsAgainst;
	}

	public int getGoalsFor() {
		return goalsFor;
	}

	public int getGoalsAgainst() {
		return goalsAgainst;
	}

	public int getRedCards() {
		return redCards;
	}

	public int getYellowCards() {
		return yellowCards;
	}

	public int getPenaltyKicks() {
		return penaltyKicks;
	}

	public List<MatchResult> getMatchResultsApplied() {
		return matchResultsApplied;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public String toString() {
		String returnString = "";
		returnString += "\nTeam:               \t" + name ;
		returnString += "\nuniqueID:           \t" + uniqueID ;
		returnString += "\ngamesPlayed:        \t" + gamesPlayed ;
		returnString += "\npoints:             \t" + points ;
		returnString += "\nwins:               \t" + wins ;
		returnString += "\nlosses:             \t" + losses ;
		returnString += "\ndraws:              \t" + draws ;
		returnString += "\nshotsFor:           \t" + shotsFor ;
		returnString += "\nshotsAgainst:       \t" + shotsAgainst ;
		returnString += "\ngoalsFor:           \t" + goalsFor ;
		returnString += "\ngoalsAgainst:       \t" + goalsAgainst ;
		returnString += "\nredCards:           \t" + redCards ;
		returnString += "\nyellowCards:        \t" + yellowCards ;
		returnString += "\npenaltyKicks:       \t" + penaltyKicks ;
		returnString += "\nmatchResultsApplied:\t" + matchResultsApplied.size() ;
		returnString += "\nplayers:            \t" + players.size() ;
		return returnString;
	}
	

	public String[] getTeamStats() {
		String[] teamStats = new String[14];
		teamStats[0] = "" + name;
		teamStats[1] = "" + gamesPlayed;
		teamStats[2] = "" + points;	
		teamStats[3] = "" + wins;
		teamStats[4] = "" + losses;
		teamStats[5] = "" + draws;
		teamStats[6] = "" + shotsFor;
		teamStats[7] = "" + shotsAgainst;
		teamStats[8] = "" + goalsFor;
		teamStats[9] = "" + goalsAgainst;
		teamStats[10] = "" + redCards;
		teamStats[11] = "" + yellowCards;
		teamStats[12] = "" + penaltyKicks;
		teamStats[13] = "" + players.size();
		return teamStats;	
	}

	public String addPlayer(Player newPlayer) {
		if (players.contains(newPlayer)) {
			return "ERROR; This player already exists on team.";
		}
		else {
			players.add(newPlayer);
			return "Player succesfully added to team.";
		}
	}


	public String applyMatchResult(boolean isHomeTeam, MatchResult result) {
		if (matchResultsApplied.contains(result)) {
			return "Error this match has already been applied to this team";
		}
		else {
			matchResultsApplied.add(result);
			gamesPlayed++;
			int teamPoints = result.getPoints(isHomeTeam);
			int opposingTeamPoints = result.getPoints(!isHomeTeam);
			goalsFor += teamPoints;
			goalsAgainst += opposingTeamPoints;
			if (teamPoints == opposingTeamPoints) {
				draws++;
				points += 1;
			}
			else if (teamPoints > opposingTeamPoints) {
				wins++;
				points += 3;
			}
			else if (teamPoints < opposingTeamPoints) {
				losses++;
			}
			shotsFor += result.getShots(isHomeTeam);
			shotsAgainst += result.getShots(!isHomeTeam);
			yellowCards += result.getYellowCards(isHomeTeam);
			redCards += result.getRedCards(isHomeTeam);
			penaltyKicks += result.getPenaltyKicks(isHomeTeam);
			return "applied MatchResult to Home Team " + name;
		}
	}

	public String unapplyMatchResult(boolean isHomeTeam, MatchResult result) {
		if (matchResultsApplied.contains(result)) {
			matchResultsApplied.remove(result);
			gamesPlayed--;
			int teamPoints = result.getPoints(isHomeTeam);
			int opposingTeamPoints = result.getPoints(!isHomeTeam);
			goalsFor -= teamPoints;
			goalsAgainst -= opposingTeamPoints;
			if (teamPoints == opposingTeamPoints) {
				draws--;
				points -= 1;
			}
			else if (teamPoints > opposingTeamPoints) {
				wins--;
				points -= 3;
			}
			else if (teamPoints < opposingTeamPoints) {
				losses--;
			}
			shotsFor -= result.getShots(isHomeTeam);
			shotsAgainst -= result.getShots(!isHomeTeam);
			yellowCards -= result.getYellowCards(isHomeTeam);
			redCards -= result.getRedCards(isHomeTeam);
			penaltyKicks -= result.getPenaltyKicks(isHomeTeam);
			return "unapplied MatchResult to Home Team " + name;
		}
		else {
			return "Error this match has not been applied to this team";
		}
	}
	
	

}
