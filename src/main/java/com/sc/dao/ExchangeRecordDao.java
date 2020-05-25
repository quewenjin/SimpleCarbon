package com.sc.dao;

import org.apache.ibatis.annotations.Param;

public interface ExchangeRecordDao {

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
