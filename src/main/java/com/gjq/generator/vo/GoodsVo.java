package com.gjq.generator.vo;

import com.gjq.generator.pojo.Goods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsVo extends Goods {

    private BigDecimal seckillPrice;

    private Integer stockCount;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
