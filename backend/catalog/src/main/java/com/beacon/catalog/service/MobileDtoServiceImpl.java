package com.beacon.catalog.service;

import com.beacon.catalog.dao.MobileDao;
import com.beacon.model.MobileDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Default implementation of {@link MobileDtoService}
 */
@Service
@Transactional
public class MobileDtoServiceImpl implements MobileDtoService {

    private MobileDao mobileDao;

    public MobileDtoServiceImpl(MobileDao mobileDao) {
        this.mobileDao = mobileDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<MobileDto> findAllMobileDtos() {
        return mobileDao.findAll();
    }
}
