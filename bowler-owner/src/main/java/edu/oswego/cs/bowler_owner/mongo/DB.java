package edu.oswego.cs.bowler_owner.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.oswego.cs.bowler_owner.models.Connection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class DB {

    static private MongoClient mongoClient;
    static private MongoDatabase originDB;
    static private MongoCollection<Document> sequences, connections;

    static public void init(String host, int port) {
        mongoClient = new MongoClient(host, port);
        connect();
    }

    /**
     * Sets up the connection to the MongoDB, and loads in the pertinent collections.
     */
    static private void connect() {
        originDB = mongoClient.getDatabase("bowler");
        sequences = originDB.getCollection("sequences");
        connections = originDB.getCollection("connections");
    }

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
}
