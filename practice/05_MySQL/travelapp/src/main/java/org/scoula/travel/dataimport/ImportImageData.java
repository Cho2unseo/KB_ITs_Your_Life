package org.scoula.travel.dataimport;

import org.scoula.database.JDBCUtil;
import org.scoula.travel.dao.TravelDao;
import org.scoula.travel.dao.TravelDaoImpl;
import org.scoula.travel.domain.TravelImageVO;

import java.io.File;

public class ImportImageData {
    public static void main(String[] args) {
        TravelDao dao = new TravelDaoImpl();

        File dir = new File("../travel-image");
        File[] files = dir.listFiles(); // 폴더 내의 파일을 리스트로 가져오기
        for (File file: files) {
            String filename = file.getName();
            // 파일 이름의 "-" 앞부분을 추출해서 관광지 no 얻기
            long travelNo = Long.parseLong(filename.split("-")[0]);

            TravelImageVO image = TravelImageVO.builder()
                    .filename(filename)
                    .travelNo(travelNo)
                    .build();

            System.out.println(image);
            dao.insertImage(image);
        }
        JDBCUtil.close();
    }
}
