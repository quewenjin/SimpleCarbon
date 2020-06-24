package com.sc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ExchangeRecordMapper {
    /**
     * 创建交易记录
     * @param productName
     * @param productNum
     * @param exchangerId
     * @param exchangeTime
     */
    void creatExchangeRecord(@Param("productName") String productName, @Param("productNum") int productNum,
                             @Param("exchangerId") String exchangerId, @Param("exchangeTime") String exchangeTime);
}
