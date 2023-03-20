package com.beacon.search.service;

import com.beacon.model.status.StatusBean;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class HealthCheckServiceImpl implements HealthCheckService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HealthCheckServiceImpl.class);

    private static final String DB_SQL_QUERY = "SELECT 1";
    private static final String EXPECTED_RESULT = "1";

    private final EntityManager entityManager;
    @Override
    public StatusBean getResourceStatus() {
        try {
            String result = entityManager.createNativeQuery(DB_SQL_QUERY).getSingleResult().toString();
            if (result.equals(EXPECTED_RESULT)) {
                return StatusBean.OK;
            } else {
                LOGGER.error("Health resource check failed. Check DB result: {}", result);
            }
        } catch (Exception e) {
            LOGGER.error("Health resource check failed", e);
        }
        return StatusBean.FAILED;
    }
}
