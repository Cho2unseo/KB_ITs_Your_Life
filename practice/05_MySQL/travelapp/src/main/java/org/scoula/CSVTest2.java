package org.scoula;

import com.opencsv.bean.CsvToBeanBuilder;
import org.scoula.travel.domain.TravelVO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CSVTest2 {
    public static void main(String[] args) throws Exception {
        // CSV 파일을 TravelVO 리스트로 매핑
        // CSV 파일 헤더명과 TravelVO 필드명이 일치해야함
        List<TravelVO> travels = new CsvToBeanBuilder<TravelVO>(new FileReader("travel.csv"))
                .withType(TravelVO.class)
                .build()
                .parse();

        travels.forEach(travel -> {
            System.out.println(travel);
        });
    }
}
