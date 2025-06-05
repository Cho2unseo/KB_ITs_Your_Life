package sec04;

import app.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;

public class UpdateOneTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("users");

        String id = "6835575e118b6c5dc18573ea";
        // eq: 지정된 필드와 값이 일치하는 문서를 찾는 필터를 생성
        Bson query = eq("_id", new ObjectId(id));

        // combine: 여러 업데이트 연산을 결합
        // set: 지정된 필드 값을 설정
        // currentTimestamp: 지정된 필드를 현재 타임스탬프로 설정
        Bson updates = Updates.combine(
                Updates.set("name", "modify name"),
                Updates.currentTimestamp("lastUpdated"));

        // 쿼리와 업데이트 내용을 사용하여 단일 문서를 업데이트
        UpdateResult result = collection.updateOne(query, updates);
        System.out.println("==> UpdateResult : " + result.getModifiedCount());

        Database.close();
    }
}
