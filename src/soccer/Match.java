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

	public 	Match() {
		uniqueID = UUID.randomUUID().toString(); 
		matchEvents = new ArrayList<MatchEvent>();
		matchResult = new MatchResult();
		complete = false;
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
				return "added MatchEvent";
			}
			else if (subscribedAwayTeam.getPlayers().contains(event.getSubscribedPlayer()) && subscribedHomeTeam.getPlayers().contains(event.getSubscribedGoalie())) {
				matchResult.applyEvent(1, event);
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
				return "added InfractionEvent";
			}
			else if (subscribedAwayTeam.getPlayers().contains(event.getSubscribedPlayer())) {
				matchResult.applyEvent(1, event);
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
				return "removed ShotEvent";
			}
			else if (subscribedAwayTeam.getPlayers().contains(event.getSubscribedPlayer()) && subscribedHomeTeam.getPlayers().contains(event.getSubscribedGoalie())) {
				matchResult.unapplyEvent(1, event);
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
				return "removed InfractionEvent";
			}
			else if (subscribedAwayTeam.getPlayers().contains(event.getSubscribedPlayer())) {
				matchResult.unapplyEvent(1, event);
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

}
