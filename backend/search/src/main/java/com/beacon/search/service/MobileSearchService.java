package com.beacon.search.service;

import com.beacon.model.Mobile;

import java.util.List;

public interface MobileSearchService {

    /**
     * Default search method uses a complex sql query.
     *
     * @param query is on the basis of which the search will be conducted.
     * @return result list with found rows.
     */
    public List<Mobile> search(String query);
}
