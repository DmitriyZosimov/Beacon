package com.beacon.catalog.service;

import com.beacon.model.status.StatusBean;

public interface HealthCheckService {

    /**
     * Resource checks
     * @return {@link StatusBean#OK} or {@link StatusBean#FAILED}
     */
    public StatusBean getResourceStatus();
}
