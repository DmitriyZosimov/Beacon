package com.beacon.search.service;

import com.beacon.model.MobileDto;
import com.beacon.search.dao.MobileSearchDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DefaultMobileSearchService implements MobileSearchService {

    private MobileSearchDao dao;

    public DefaultMobileSearchService(MobileSearchDao dao) {
        this.dao = dao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<MobileDto> search(String query) {
        return dao.search(query);
    }
}