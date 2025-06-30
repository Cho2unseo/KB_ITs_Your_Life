package com.yuko.icecream.dto;

import com.yuko.icecream.domain.IcecreamVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IcecreamDTO {
    private Long no;
    private String name;
    private String flavor;
    private Integer price;
    private Date regDate;

    public static IcecreamDTO of(IcecreamVO vo) {
        return vo == null ? null : IcecreamDTO.builder()
                .no(vo.getNo())
                .name(vo.getName())
                .flavor(vo.getFlavor())
                .price(vo.getPrice())
                .regDate(vo.getRegDate())
                .build();
    }

    public IcecreamVO toVo() {
        return IcecreamVO.builder()
                .no(no)
                .name(name)
                .flavor(flavor)
                .price(price)
                .regDate(regDate)
                .build();
    }
}
