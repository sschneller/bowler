package edu.oswego.cs.bowler_owner.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.oswego.cs.bowler_owner.models.Connection;
import edu.oswego.cs.bowler_owner.models.League;
import edu.oswego.cs.bowler_owner.models.Player;
import edu.oswego.cs.bowler_owner.models.Team;
import org.bson.Document;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

public class DB {

    private static MongoClient mongoClient;
    private static MongoDatabase originDB;
    private static MongoCollection<Document> connections, leagues, players, pricings, sequences, teams, accounts;

    /* --- Initializer Methods --- */

    /**
     * Creates the client from the credentials, and then initializes the collections
     */
    public static void init() {
        mongoClient = new MongoClient(new MongoClientURI("mongodb://" + Credentials.USERNAME + ":" + Credentials.PASSWORD + "@" + Credentials.HOST + ":" + Credentials.PORT + "/bowler"));
        connect();
    }

    /**
     * Sets up the connection to the MongoDB, and loads in the pertinent collections.
     */
    private static void connect() {
        // STORE DB REFERENCE
        originDB = mongoClient.getDatabase("bowler");
        // STORE COLLECTION REFERENCES
        connections = originDB.getCollection("connections");
        leagues = originDB.getCollection("leagues");
        players = originDB.getCollection("players");
        pricings = originDB.getCollection("pricings");
        sequences = originDB.getCollection("sequences");
        teams = originDB.getCollection("teams");
        accounts = originDB.getCollection("accounts");
    }

    /* --- Connection Methods --- */

    /**
     * Returns the connections stored in the 'connections' collection as a list of Connection model objects
     * @return List of Connection models representing the stored data
     */
    public static List<Connection> getStoredConnections() {
        List<Connection> connectionList = new ArrayList<>();
        for(Document d : connections.find()) {
            connectionList.add(new Connection(d.getInteger("laneid"), d.getString("ip")));
        }
        return connectionList;
    }

    /**
     * Finds the associated IP from the laneid
     * @param laneid The unique id associated with the lane
     * @return The ip associated with the provided laneid
     */
    public static String getIp(int laneid) {
        for(Connection c : getStoredConnections()) {
            if(c.getLaneid() == laneid) {
                return c.getIp();
            }
        }
        return null;
    }

    /**
     * Adds a connection to the 'connections' collection
     * @param c The connection you want to store
     */
    public static void insertConnection(Connection c) {
        Document doc = new Document("laneid", c.getLaneid()).append("ip", c.getIp());
        connections.insertOne(doc);
    }

    /* --- Sequence Methods --- */

    /**
     * Get the current value of the sequence provided
     * @param sequence The String representation of the sequence name
     * @return The current value of the sequence
     */
    public static int getCurrValBySeq(String sequence) {
        for(Document d : sequences.find()) {
            if(d.getString("sequence").equals(sequence)) {
                return d.getInteger("value");
            }
        }
        return -1;
    }

    /**
     * Increments the provided sequence by 1
     * @param sequence The String name of the sequence
     */
    public static void incrementSequence(String sequence) {
        sequences.updateOne(eq("sequence", sequence), new Document("$set", new Document("value", getCurrValBySeq(sequence) + 1)));
    }

    /* --- Account Methods --- */

    /**
     * Insert a new account into the 'accounts' collection
     * @param username The username to store
     * @param password The password to store
     */
    public static void insertAccount(String username, String password) {
        try {
            Document doc = new Document("accountid", getCurrValBySeq("accountid")).append("username", username).append("hashed_password", Accounts.generateStrongPasswordHash(password));
            accounts.insertOne(doc);
        }
        catch(NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks to see if the given username matches any in the 'accounts' collection
     * @param username The username to find
     * @return True if the username is in the collection, false if it isn't
     */
    public static boolean verifyUsername(String username) {
        for(Document d : accounts.find()) {
            if(d.getString("username").equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks to see if the given password matches the associated given username
     * @param username The username to check the password against
     * @param password The password to check
     * @return True if the password matches the one associated with the username, false if it doesn't
     */
    public static boolean verifyPassword(String username, String password) {
        for(Document d : accounts.find()) {
            if(d.getString("username").equals(username)) {
                try {
                    if(Accounts.validatePassword(password, d.getString("hashed_password"))) {
                        return true;
                    }
                }
                catch(NoSuchAlgorithmException | InvalidKeySpecException e) {
                    e.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    /* --- League Methods --- */

    public static void insertLeague(League l) {
        Document doc = new Document("leagueid", l.getLeagueid()).append("league_name", l.getLeague_name());
        leagues.insertOne(doc);
    }

    public static League findLeagueByName(String name) {
        for(Document d : leagues.find()) {
            if(d.getString("league_name").equals(name)) {
                League l = new League();
                l.setLeagueid(d.getInteger("leagueid"));
                l.setLeague_name(d.getString("league_name"));
                return l;
            }
        }
        return null;
    }

    /* --- Team Methods --- */

    public static void insertTeam(Team t) {
        Document doc = new Document("teamid", t.getTeamid()).append("team_name", t.getTeam_name()).append("in_league", t.getIn_league()).append("points_won", t.getPoints_won()).append("points_lost", t.getPoints_lost());
        teams.insertOne(doc);
    }

    public static Team findTeamByName(String name) {
        for(Document d : teams.find()) {
            if(d.getString("team_name").equals(name)) {
                Team t = new Team();
                t.setTeamid(d.getInteger("teamid"));
                t.setTeam_name(d.getString("team_name"));
                t.setIn_league(d.getInteger("in_league"));
                t.setPoints_won(d.getInteger("points_won"));
                t.setPoints_lost(d.getInteger("points_lost"));
                return t;
            }
        }
        return null;
    }

    /* --- Player Methods --- */

    public static void insertPlayer(Player p) {
        Document doc = new Document("playerid", p.getPlayerid()).append("player_name", p.getPlayer_name()).append("on_team", p.getOn_team()).append("average", p.getAverage()).append("total_pins", p.getTotal_pins()).append("total_games", p.getTotal_games()).append("high_game", p.getHigh_game()).append("high_series", p.getHigh_series()).append("points_won", p.getPoints_won()).append("points_lost", p.getPoints_lost());
        players.insertOne(doc);
    }

    public static Player findPlayerByName(String name) {
        for(Document d : players.find()) {
            if(d.getString("player_name").equals(name)) {
                Player p = new Player();
                p.setPlayerid(d.getInteger("playerid"));
                p.setPlayer_name(d.getString("player_name"));
                p.setOn_team(d.getInteger("on_team"));
                p.setAverage(d.getInteger("average"));
                p.setTotal_pins(d.getInteger("total_pins"));
                p.setTotal_games(d.getInteger("total_games"));
                p.setHigh_game(d.getInteger("high_game"));
                p.setHigh_series(d.getInteger("high_series"));
                p.setPoints_won(d.getInteger("points_won"));
                p.setPoints_lost(d.getInteger("points_lost"));
                return p;
            }
        }
        return null;
    }

    /* --- Pricing Methods --- */

    public static void insertPricing(String type, double value) {
        Document doc = new Document("type", type).append("value", value);
        pricings.insertOne(doc);
    }

    public static double getPrice(String type) {
        for(Document d : pricings.find()) {
            if(d.getString("type").equals(type)) {
                return d.getDouble("value");
            }
        }
        return -1.0;
    }

    public static void updatePrice(String type, double newValue) {
        pricings.updateOne(eq("type", type), combine(set("value", newValue)));
    }
}
