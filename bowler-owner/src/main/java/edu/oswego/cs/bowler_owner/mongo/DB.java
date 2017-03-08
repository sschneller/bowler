package edu.oswego.cs.bowler_owner.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.oswego.cs.bowler_owner.models.Connection;
import org.bson.Document;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class DB {

    private static MongoClient mongoClient;
    private static MongoDatabase originDB;
    private static MongoCollection<Document> sequences, connections, users;

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
        originDB = mongoClient.getDatabase("bowler");
        sequences = originDB.getCollection("sequences");
        connections = originDB.getCollection("connections");
        users = originDB.getCollection("users");
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

    /* --- User Methods --- */

    /**
     * Insert a new user into the 'user' collection
     * @param username The username to store
     * @param password The password to store
     */
    public static void insertUser(String username, String password) {
        try {
            Document doc = new Document("userid", getCurrValBySeq("userid")).append("username", username).append("hashed_password", Accounts.generateStrongPasswordHash(password));
            users.insertOne(doc);
        }
        catch(NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks to see if the given username matches any in the 'user' collection
     * @param username The username to find
     * @return True if the username is in the collection, false if it isn't
     */
    public static boolean verifyUsername(String username) {
        for(Document d : users.find()) {
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
        for(Document d : users.find()) {
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
}
