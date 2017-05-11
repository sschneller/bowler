package edu.oswego.cs.bowler.models;

public class Player implements Comparable {
    private int playerid;
    private String player_name;
    private int on_team;
    private int average;
    private int total_pins;
    private int total_games;
    private int high_game;
    private int high_series;
    private int points_won;
    private int points_lost;
    private int handicap;
    private int handicap_series;

    public int getPlayerid() {
        return playerid;
    }

    public void setPlayerid(int playerid) {
        this.playerid = playerid;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public int getOn_team() {
        return on_team;
    }

    public void setOn_team(int on_team) {
        this.on_team = on_team;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public int getTotal_pins() {
        return total_pins;
    }

    public void setTotal_pins(int total_pins) {
        this.total_pins = total_pins;
    }

    public int getTotal_games() {
        return total_games;
    }

    public void setTotal_games(int total_games) {
        this.total_games = total_games;
    }

    public int getHigh_game() {
        return high_game;
    }

    public void setHigh_game(int high_game) {
        this.high_game = high_game;
    }

    public int getHigh_series() {
        return high_series;
    }

    public void setHigh_series(int high_series) {
        this.high_series = high_series;
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

    public int getHandicap() {
        return handicap;
    }

    public void setHandicap(int handicap) {
        this.handicap = handicap;
    }

    public int getHandicap_series() {
        return handicap_series;
    }

    public void setHandicap_series(int handicap_series) {
        this.handicap_series = handicap_series;
    }

    @Override
    public int compareTo(Object o) {
        if(this.getPlayerid() > 0 && ((Player)o).getPlayerid() > 0) {
            if(((Player)o).getPlayerid() < this.getPlayerid()) return -1;
            else if(((Player)o).getPlayerid() == this.getPlayerid()) return 0;
            else if(((Player)o).getPlayerid() > this.getPlayerid()) return 1;
        }
        else if(!this.getPlayer_name().equals("") && !((Player)o).getPlayer_name().equals("")){
            return this.getPlayer_name().compareTo(((Player)o).getPlayer_name());
        }
        return 0;
    }
}
