package com.yuko.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuyDTO {
    private Long id;
    private String stockCode;
    private String stockName;
    private int price;
    private String buyDate;
}
