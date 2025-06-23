package com.yuko.icecream.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IcecreamVO {
    private Long no;
    private String name;
    private String flavor;
    private Integer price;
    private Date regDate;

}
