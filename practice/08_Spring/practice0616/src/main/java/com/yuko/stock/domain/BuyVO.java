package com.yuko.stock.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuyVO {
    private Long id;
    private String stockCode;
    private String stockName;
    private int price;
    private Date buyDate;
}
