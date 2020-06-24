package com.sc.service;

import com.sc.mapper.ExchangeRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExchangeRecordService {
    @Autowired
    ExchangeRecordMapper exchangeRecordMapper;
}
