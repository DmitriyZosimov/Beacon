package com.beacon.catalog.service;

import com.beacon.catalog.dao.MobileDao;
import com.beacon.model.Mobile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Default implementation of {@link MobileService}
 */
@Service
@Transactional
public class MobileServiceImpl implements MobileService {

    private MobileDao mobileDao;

    public MobileServiceImpl(MobileDao mobileDao) {
        this.mobileDao = mobileDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Mobile> findAllMobiles() {
        return mobileDao.findAll();
    }
}
