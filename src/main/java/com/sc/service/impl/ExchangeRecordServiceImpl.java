package com.sc.service.impl;

import com.sc.dao.ExchangeRecordDao;
import com.sc.service.ExchangeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRecordServiceImpl implements ExchangeRecordService {
    @Autowired
    private ExchangeRecordDao exchangeRecordDao;


}
