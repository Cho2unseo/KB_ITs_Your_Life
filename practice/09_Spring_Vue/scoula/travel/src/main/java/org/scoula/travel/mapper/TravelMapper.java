package org.scoula.travel.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.scoula.common.pagination.PageRequest;
import org.scoula.travel.domain.TravelImageVO;
import org.scoula.travel.domain.TravelVO;

import java.util.List;

@Mapper
public interface TravelMapper {
    int getTotalCount();

    List<String> getDistricts();

    List<TravelVO> getTravels();

    List<TravelVO> getPage(PageRequest pageRequest);

    List<TravelVO> getTravelsByDistrict(String district);

    TravelVO getTravel(Long no);

    List<TravelImageVO> getImages(Long travelNo);

    TravelImageVO getImage(Long no);
}
