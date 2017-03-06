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

    static public void init() {
        mongoClient = new MongoClient(new MongoClientURI("mongodb://" + Credentials.USERNAME + ":" + Credentials.PASSWORD + "@" + Credentials.HOST + ":" + Credentials.PORT + "/bowler"));
        connect();
    }

    /**
     * Sets up the connection to the MongoDB, and loads in the pertinent collections.
     */
    static private void connect() {
        originDB = mongoClient.getDatabase("bowler");
        sequences = originDB.getCollection("sequences");
        connections = originDB.getCollection("connections");
        users = originDB.getCollection("users");
    }

    /* --- Connection Methods --- */

    static public List<Connection> getStoredConnections() {
        List<Connection> connectionList = new ArrayList<>();
        for(Document d : connections.find()) {
            connectionList.add(new Connection(d.getInteger("laneid"), d.getString("ip")));
            // model.addElement("Lane " + d.getInteger("laneid").toString()/* + " - " + d.getString("ip")*/);
        }
        return connectionList;
    }

    static public String getIp(int laneid) {
        for(Connection c : getStoredConnections()) {
            if(c.getLaneid() == laneid) {
                return c.getIp();
            }
        }
        return null;
    }

    static public void insertConnection(Connection c) {
        Document doc = new Document("laneid", c.getLaneid()).append("ip", c.getIp());
        connections.insertOne(doc);
    }

    /* --- Sequence Methods --- */

    static public int getCurrValBySeq(String sequence) {
        for(Document d : sequences.find()) {
            if(d.getString("sequence").equals(sequence)) {
                return d.getInteger("value");
            }
        }
        return -1;
    }

    static public void incrementSequence(String sequence) {
        sequences.updateOne(eq("sequence", sequence), new Document("$set", new Document("value", getCurrValBySeq(sequence) + 1)));
    }

    /* --- User Methods --- */

    static public void insertUser(String username, String password) {
        try {
            Document doc = new Document("username", username).append("hashed_password", Accounts.generateStrongPasswordHash(password));
            connections.insertOne(doc);
        }
        catch(NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    static public boolean verifyUsername(String username) {
        for(Document d : users.find()) {
            if(d.getString(""))
        }
    }

    static public boolean verifyPassword(String password) {

    }
}
