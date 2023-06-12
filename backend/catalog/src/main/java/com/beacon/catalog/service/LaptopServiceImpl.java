package com.beacon.catalog.service;

import com.beacon.catalog.dao.LaptopDao;
import com.beacon.catalog.transformer.LaptopTransformer;
import com.beacon.model.dtos.LaptopDto;
import com.beacon.model.dtos.LaptopPreviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class LaptopServiceImpl implements LaptopService {

    //TODO: Togglez
    private static final boolean tuple = true;

    private final LaptopDao laptopDao;
    private final LaptopTransformer transformer;
    @Override
    public List<LaptopDto> findAllDto() {
        if (tuple) {
            return transformer.transformTupleList(laptopDao.findAllByToTuple());
        } else {
            return transformer.transformList(laptopDao.findAllBy());
        }
    }

    @Override
    public Set<LaptopPreviewDto> findAllLaptopPreviewDto() {
        return laptopDao.findAllPreviewBy();
    }

    @Override
    public Optional<LaptopDto> findDtoByComputerId(String computerId) {
        if (tuple) {
            return transformer.transformFromTuple(laptopDao.findByComputerIdToTuple(computerId));
        } else {
            return transformer.transform(laptopDao.findByComputerId(computerId));
        }
    }
}
