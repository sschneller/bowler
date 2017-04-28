package edu.oswego.cs.bowler.models;

public class Team {
    private int teamid;
    private String team_name;
    private int in_league;
    private int points_won;
    private int points_lost;

    public int getTeamid() {
        return teamid;
    }

    public void setTeamid(int teamid) {
        this.teamid = teamid;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public int getIn_league() {
        return in_league;
    }

    public void setIn_league(int in_league) {
        this.in_league = in_league;
    }

    public int getPoints_won() {
        return points_won;
    }

    public void setPoints_won(int points_won) {
        this.points_won = points_won;
    }

    public int getPoints_lost() {
        return points_lost;
    }

    public void setPoints_lost(int points_lost) {
        this.points_lost = points_lost;
    }
}
