package sec03;

import app.Database;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;

public class FindOneTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");

        String id = "68350c3e1b7d9317d05086f9";
        // Filters.eq를 import 후 사용
        Bson query = eq("_id", new ObjectId(id));

        // first는 가장 먼저 찾은 문서 하나 반환
        Document doc = collection.find(query).first();
        System.out.println("==> findByIdResult : " + doc);
        Database.close();
    }
}
