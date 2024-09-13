package org.csms.DataBaseCon;

import com.mongodb.MongoClientURI;
import com.mongodb.client.*;
import org.bson.Document;

public class DBConnection {

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> usersCollection;

    public DBConnection() {
        String uri = "mongodb://localhost:27017";
        String dbName = "CSMS";

        mongoClient = MongoClients.create(uri);
        database = mongoClient.getDatabase(dbName);
        usersCollection = database.getCollection("userLogin");
    }

    public boolean verifyLogin(String username, String password) {
        Document query = new Document("username", username).append("password", password);
        Document user = usersCollection.find(query).first();

        return user != null;
    }

    public void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
