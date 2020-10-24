
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

public class ConnectToDB {
//	public static String GetDocumentFromDataBase(String dataBase, String DBcollection, String field, String value) throws Exception{
//try {
//	MongoClient mongoClient = new mongoClient(
//				"mongodb+srv://" + System.getenv("MONGO_USERNAME") + ":" + System.getenv("MONGO_PASSWORD")
//						+ "@profitproject.0vxpt.mongodb.net/" + dataBase + "?retryWrites=true&w=majority");
//
//	//	MongoClient mongoClient = new MongoClient(uri);
//		MongoDatabase database = mongoClient.getDatabase(dataBase);
//		MongoCollection collection = database.getCollection(DBcollection);
//		String myDoc =  collection.find(eq(field, value)).first().toString();
//		System.out.println(myDoc);
//		mongoClient.close();
//		return myDoc;}
//catch(Exception e) {
//	System.err.println(e);
//	return null;
//}}
	
	public static String GetFromDB(String dataBase,String collectionName, String field) {
		String valueBack;
		System.out.println(System.getenv("MONGO_USERNAME"));
		System.out.println(System.getenv("MONGO_PASSWORD"));
		//System.out.println(System.getenv("MONGO_USERNAME"));

		MongoClient mongoClient = new MongoClient(	"mongodb+srv://" + System.getenv("MONGO_USERNAME") + ":" + System.getenv("MONGO_PASSWORD")
		+ "@profitproject.0vxpt.mongodb.net/" + dataBase + "?retryWrites=true&w=majority");
		MongoDatabase database = mongoClient.getDatabase("sdcc");
		Document myDoc = database.getCollection(collectionName).find().first();
		if (myDoc != null) {
			valueBack = myDoc.get(field).toString();
			mongoClient.close();
			return valueBack;
		}
		return null;
	}


	public static void main(String[] args) throws Exception {
		System.out.println(GetFromDB("Profitproject", "tasks", "creater"));

		System.out.println("vvvv");
		//System.out.println(GetDocumentFromDataBase("Profitproject", "tasks", "creater", "vladi"));

	}

}
