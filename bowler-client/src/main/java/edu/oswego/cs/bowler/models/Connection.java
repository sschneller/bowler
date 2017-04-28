package edu.oswego.cs.bowler.models;

public class Connection {
    private int laneid;
    private String ip;

    public Connection(int laneid, String ip) {
        this.laneid = laneid;
        this.ip = ip;
    }

    public String toString() {
        return "Lane " + getLaneid();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getLaneid() {
        return laneid;
    }

    public void setLaneid(int laneid) {
        this.laneid = laneid;
    }
}
