package org.scoula.food.dataimport;

import com.opencsv.bean.CsvToBeanBuilder;
import org.scoula.food.JDBCUtil;
import org.scoula.food.dao.RestaurantDao;
import org.scoula.food.dao.RestaurantDaoImpl;
import org.scoula.food.domain.RestaurantReviewVO;

import java.io.FileReader;
import java.util.List;

public class ImportReviewData {
    public static void main(String[] args) throws Exception {
        RestaurantDao dao = new RestaurantDaoImpl();
        List<RestaurantReviewVO> reviews = new CsvToBeanBuilder<RestaurantReviewVO>(new FileReader("reviews_pokemon.csv"))
                .withType(RestaurantReviewVO.class)
                .build()
                .parse();
        reviews.forEach(r -> {
            System.out.println("✅ 저장됨: " + r.getWriter() + " -> " + r.getRestaurantId());
            dao.insertReview(r);
        });
        JDBCUtil.close();
    }
}
