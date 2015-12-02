package soccer;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class Match {

	private String uniqueID;
	private Team subscribedHomeTeam;
	private Team subscribedAwayTeam;
	private List<MatchEvent> matchEvents;
	private MatchResult matchResult;
	private boolean complete;
	private Season season;

	public 	Match(Season season) {
		uniqueID = UUID.randomUUID().toString(); 
		matchEvents = new ArrayList<MatchEvent>();
		matchResult = new MatchResult();
		complete = false;
		this.season = season;
	}

	public Team getSubscribedHomeTeam() {
		return subscribedHomeTeam;
	}

	public Team getSubscribedAwayTeam() {
		return subscribedAwayTeam;
	}

	public List<MatchEvent> getMatchEvents() {
		return matchEvents;
	}

	public String setSubscribedHomeTeam(Team homeTeam) {
		subscribedHomeTeam = homeTeam;
		return "HomeTeam " + subscribedHomeTeam.getName() + " succesfully subscribed to Match.";
	}

	public String setSubscribedAwayTeam(Team awayTeam) {
		subscribedAwayTeam = awayTeam;
		return "AwayTeam " + subscribedAwayTeam.getName() + " succesfully subscribed to Match.";
	}

	public MatchResult getMatchResult() {
		return matchResult;
	}

	public String addMatchEvent(ShotEvent event) {
		if (matchEvents.contains(event)) {
			return "MatchEvent already added to Match";
		}
		else {
			matchEvents.add(event);
			if (subscribedHomeTeam.getPlayers().contains(event.getSubscribedPlayer()) && subscribedAwayTeam.getPlayers().contains(event.getSubscribedGoalie())) {
				matchResult.applyEvent(0, event);
				season.publishSeason();
				return "added MatchEvent";
			}
			else if (subscribedAwayTeam.getPlayers().contains(event.getSubscribedPlayer()) && subscribedHomeTeam.getPlayers().contains(event.getSubscribedGoalie())) {
				matchResult.applyEvent(1, event);
				season.publishSeason();
				return "added MatchEvent";
			}
			else {
				return "MatchEvent player is not on home or away team";
			}
		}
	}

	public String addMatchEvent(InfractionEvent event) {
		if (matchEvents.contains(event)) {
			return "InfractionEvent already added to Match";
		}
		else {
			matchEvents.add(event);
			
			if (subscribedHomeTeam.getPlayers().contains(event.getSubscribedPlayer())) {
				matchResult.applyEvent(0, event);
				season.publishSeason();
				return "added InfractionEvent";
			}
			else if (subscribedAwayTeam.getPlayers().contains(event.getSubscribedPlayer())) {
				matchResult.applyEvent(1, event);
				season.publishSeason();
				return "added InfractionEvent";
			}
			else {
				return "InfractionEvent player is not on home or away team";
			}
		}
	}

	public String removeMatchEvent(ShotEvent event) {
		if (matchEvents.contains(event)) {
			matchEvents.remove(event);
			if (subscribedHomeTeam.getPlayers().contains(event.getSubscribedPlayer()) && subscribedAwayTeam.getPlayers().contains(event.getSubscribedGoalie())) {
				matchResult.unapplyEvent(0, event);
				season.publishSeason();
				return "removed ShotEvent";
			}
			else if (subscribedAwayTeam.getPlayers().contains(event.getSubscribedPlayer()) && subscribedHomeTeam.getPlayers().contains(event.getSubscribedGoalie())) {
				matchResult.unapplyEvent(1, event);
				season.publishSeason();
				return "removed ShotEvent";
			}
			else {
				return "MatchEvent player is not on home or away team";
			}
		}
		else {
			return "MatchEvent does not exist in Match";
		}
	}

	public String removeMatchEvent(InfractionEvent event) {
		if (matchEvents.contains(event)) {
			matchEvents.remove(event);
			if (subscribedHomeTeam.getPlayers().contains(event.getSubscribedPlayer())) {
				matchResult.unapplyEvent(0, event);
				season.publishSeason();
				return "removed InfractionEvent";
			}
			else if (subscribedAwayTeam.getPlayers().contains(event.getSubscribedPlayer())) {
				matchResult.unapplyEvent(1, event);
				season.publishSeason();
				return "removed InfractionEvent";
			}
			else {
				return "MatchEvent player is not on home or away team";
			}
		}
		else {
			return "MatchEvent does not exist in Match";
		}
	}

	public String endMatch() {
		if (!complete) {
			complete = true;
			publishTeamStats();
			publishPlayerStats();
			//season.publishSeason();
			//season.getLeague().publishToRankings()
			season.publishSeason();
			return "Match was succesfully ended";
		}
		else {
			return "Match is already ended";
		}
	}

	public String unendMatch() {
		if (complete) {
			complete = false;
			unpublishTeamStats();
			unpublishPlayerStats();
			//season.publishSeason();
			//season.getLeague().publishToRankings()
			season.publishSeason();
			return "Match was succesfully unended";
		}
		else {
			return "Match is not ended";
		}
	}

	public String publishPlayerStats() {
		for (MatchEvent event : matchEvents) {
			event.publishMatchEvent();
		}
		for (Player player : subscribedHomeTeam.getPlayers()) {
			player.playedMatch();
		}
		for (Player player : subscribedAwayTeam.getPlayers()) {
			player.playedMatch();
		}
		return "Match was published to every player on HomeTeam and AwayTeam";
	}

	public String unpublishPlayerStats() {
		for (MatchEvent event : matchEvents) {
			event.unpublishMatchEvent();
		}
		for (Player player : subscribedHomeTeam.getPlayers()) {
			player.unplayedMatch();
		}
		for (Player player : subscribedAwayTeam.getPlayers()) {
			player.unplayedMatch();
		}
		return "Match was unpublished from every player on HomeTeam and AwayTeam";
	}

	public String publishTeamStats() {
		subscribedHomeTeam.applyMatchResult(true, matchResult);
		subscribedAwayTeam.applyMatchResult(false, matchResult);
		return "Match was published to HomeTeam and AwayTeam";
	}

	public String unpublishTeamStats() {
		subscribedHomeTeam.unapplyMatchResult(true, matchResult);
		subscribedAwayTeam.unapplyMatchResult(false, matchResult);
		return "Match was unpublished from HomeTeam and AwayTeam";
	}

	public String toString() {
		String returnString = "\nMatch:";
		returnString += "\nuniqueID:   \t" + uniqueID ;
		returnString += "\ncomplete:   \t" + complete ;
		if (subscribedHomeTeam != null) {
			returnString += "\nHomeTeam:   \t" + subscribedHomeTeam.getName();
		}
		else {
			returnString += "\nHomeTeam:   \tNot set";
		}
		if (subscribedAwayTeam != null) {
			returnString += "\nAwayTeam:   \t" + subscribedAwayTeam.getName();
		}
		else {
			returnString += "\nAwayTeam:   \tNot set";
		}
		returnString += "\nmatchEvents:\t" + matchEvents.size();
		returnString += matchResult.toString();
		return returnString;
	}

	public String[] getMatchData() {
		String[] matchData = new String[13];
		matchData[0] = subscribedHomeTeam.getName();
		matchData[1] = "" + matchResult.getRedCards(true);
		matchData[2] = "" + matchResult.getYellowCards(true);
		matchData[3] = "" + matchResult.getPenaltyKicks(true);
		matchData[4] = "" + matchResult.getShots(true);
		matchData[5] = "" + matchResult.getPoints(true);
		matchData[6] = "vs";
		matchData[7] = "" + matchResult.getPoints(false);
		matchData[8] = "" + matchResult.getShots(false);
		matchData[9] = "" + matchResult.getPenaltyKicks(false);
		matchData[10] = "" + matchResult.getYellowCards(false);
		matchData[11] = "" + matchResult.getRedCards(false);
		matchData[12] = subscribedAwayTeam.getName();
		return matchData;
	}

}
