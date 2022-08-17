package com.beacon.search.service;

import com.beacon.model.Mobile;
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
    public List<Mobile> search(String query) {
        if (query.isBlank()) {
            return null;
        }
        return dao.search(query.strip().replaceAll("\\s+", " "));
    }
}
