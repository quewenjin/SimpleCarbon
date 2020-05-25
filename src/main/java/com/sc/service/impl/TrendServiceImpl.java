package com.sc.service.impl;

import com.sc.dao.TrendDao;
import com.sc.service.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrendServiceImpl implements TrendService {
    @Autowired
    private TrendDao trendDao;


    @Override
    public List<String> getTrendPicture(String theUserId) {
        return trendDao.getTrendPicture(theUserId);
    }
}
