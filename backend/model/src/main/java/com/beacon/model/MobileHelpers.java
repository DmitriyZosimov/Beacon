package com.beacon.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum MobileHelpers {

    @JsonProperty("removed")
    REMOVED("removed");

    private String id;

    MobileHelpers(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
