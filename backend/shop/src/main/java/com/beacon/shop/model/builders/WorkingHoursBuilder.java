package com.beacon.shop.model.builders;

import com.beacon.shop.model.WorkingHours;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 * A plain builder to generate working hours for every day of week.
 */
public class WorkingHoursBuilder {

    private static final WorkingHoursBuilder BUILDER = new WorkingHoursBuilder();

    Map<DayOfWeek, WorkingHours> workingHoursMap = new HashMap<>();

    public static WorkingHoursBuilder create() {
        return BUILDER;
    }

    public WorkingHoursBuilder setMonday(LocalTime open, LocalTime close) {
        this.workingHoursMap.put(DayOfWeek.MONDAY, new WorkingHours(open, close));
        return BUILDER;
    }

    public WorkingHoursBuilder setTuesday(LocalTime open, LocalTime close) {
        this.workingHoursMap.put(DayOfWeek.TUESDAY, new WorkingHours(open, close));
        return BUILDER;
    }

    public WorkingHoursBuilder setWednesday(LocalTime open, LocalTime close) {
        this.workingHoursMap.put(DayOfWeek.WEDNESDAY, new WorkingHours(open, close));
        return BUILDER;
    }

    public WorkingHoursBuilder setThursday(LocalTime open, LocalTime close) {
        this.workingHoursMap.put(DayOfWeek.THURSDAY, new WorkingHours(open, close));
        return BUILDER;
    }

    public WorkingHoursBuilder setFriday(LocalTime open, LocalTime close) {
        this.workingHoursMap.put(DayOfWeek.FRIDAY, new WorkingHours(open, close));
        return BUILDER;
    }

    public WorkingHoursBuilder setSaturday(LocalTime open, LocalTime close) {
        this.workingHoursMap.put(DayOfWeek.SATURDAY, new WorkingHours(open, close));
        return BUILDER;
    }

    public WorkingHoursBuilder setSunday(LocalTime open, LocalTime close) {
        this.workingHoursMap.put(DayOfWeek.SUNDAY, new WorkingHours(open, close));
        return BUILDER;
    }

    public Map<DayOfWeek, WorkingHours> build() {
        return this.workingHoursMap;
    }
}
