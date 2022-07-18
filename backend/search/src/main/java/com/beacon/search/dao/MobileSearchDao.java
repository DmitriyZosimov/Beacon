package com.beacon.search.dao;

import com.beacon.model.MobileDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobileSearchDao extends JpaRepository<MobileDto, String> {

    /**
     * Default search method uses a complex sql query.
     * Input string first of all is split into words and saved to an array. Every element of the array is attached at
     * the beginning and at the tail with %. Several columns separately compares with the every element of the array.
     * It is necessary to count matches. The most fitted row will be above in the result list. If several rows have
     * the same count of the matches, the row will be above which has release year value is more than another one.
     * The result list contains only first ten fitted rows.
     *
     * @param query is on the basis of which the search will be conducted.
     * @return result list with found rows.
     */
    @Query(nativeQuery = true,
            value = "with request as (select (concat('%', arr, '%')) from unnest(string_to_array(lower(:query), ' ')) as arr) " +
                    "select *, 0 as clazz_ " +
                    "from (" +
                    "   select * from mobile_dto m where lower(m.brand) like any (select * from request) " +
                    "   union all " +
                    "   select * from mobile_dto m where lower(m.model) like any (select * from request) " +
                    "   union all " +
                    "   select * from mobile_dto m where lower(m.color) like any (select * from request) " +
                    "   union all " +
                    "   select * from mobile_dto m where concat(m.ram, m.storage_capacity, m.battery) like any " +
                    "(select * from request) " +
                    "   union all " +
                    "   select * from mobile_dto m where lower(m.os) like any (select * from request) " +
                    "   union all " +
                    "   select * from mobile_dto m where lower(m.chipset_model) like any (select * from request) " +
                    "   union all " +
                    "   select * from mobile_dto m where lower(m.camera_resolution) like any (select * from request) " +
                    "   ) as ir " +
                    "group by ir.mobile_id, ir.brand, ir.model, ir.os, ir.battery, ir.color, ir.chipset_model, " +
                    "ir.camera_resolution, ir.ram, ir.storage_capacity, ir.release_year, ir.display_resolution, " +
                    "ir.display_technology, ir.screen_size, ir.sim_card_slot " +
                    "order by count(*) desc, ir.release_year desc limit 10")
    public List<MobileDto> search(@Param("query") String query);
}


