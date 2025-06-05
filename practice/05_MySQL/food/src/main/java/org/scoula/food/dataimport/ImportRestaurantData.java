package org.scoula.food.dataimport;

import com.opencsv.bean.CsvToBeanBuilder;
import org.scoula.food.JDBCUtil;
import org.scoula.food.dao.RestaurantDao;
import org.scoula.food.dao.RestaurantDaoImpl;
import org.scoula.food.domain.RestaurantVO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ImportRestaurantData {
    public static void main(String[] args) throws FileNotFoundException {
        RestaurantDao dao = new RestaurantDaoImpl();
        List<RestaurantVO> list = new CsvToBeanBuilder<RestaurantVO>(new FileReader("restaurant.csv"))
                .withType(RestaurantVO.class)
                .build()
                .parse();
        list.forEach(res -> {
            System.out.println("📩 저장 중: " + res.getName());
            dao.insert(res);
        });
        JDBCUtil.close();
    }
}
