package com.beacon.model.order;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TaskState {
    @JsonProperty("new")
    NEW("new"),
    @JsonProperty("in progress")
    IN_PROGRESS("in progress"),
    @JsonProperty("completed")
    COMPLETED("completed"),
    @JsonProperty("cancelled")
    CANCELLED("cancelled");

    private String state;

    private TaskState(String state) {
        this.state = state;
    }
}
