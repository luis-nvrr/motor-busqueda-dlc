package Infraestructura;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoConnection {
   MongoClient mongoClient;

   public MongoConnection(){
       mongoClient = MongoClients.create();
   }
}
