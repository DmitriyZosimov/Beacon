package com.beacon.catalog.dao;

import com.beacon.model.Mobile;
import com.beacon.model.dtos.MobileDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Dao class is to manipulate with mobile data in database.
 */
@Repository
public interface MobileDao extends JpaRepository<Mobile, String> {

    /**
     * JPA has only three strategies of inheritance. And the strategy does not exist among them which allow to get only
     * values of superclass. It has to modify one of them. JOINED strategy is used by default (see {@link Mobile}).
     * Hibernate uses a value "clazz_" to determine subclasses of our superclass:
     * <p>
     * Hibernate:
     * select mobilef0_.mobile_id as mobile_i1_0_0_, mobilef0_1_.battery as battery2_0_0_,<...></...>
     * case
     * when mobile0_1_.mobile_id is not null
     * then 1
     * when mobile0_.mobile_id is not null
     * then 0
     * end as clazz_
     * from mobile_ mobile0_ left outer join mobile_full mobile0_1_
     * on mobile0_.mobile_id=mobile0_1_.mobile_id
     * <p>
     * In case only superclass values is needed, clazz_ value must be explicitly input as 0.
     * To resolve this situation a native sql should be used.
     *
     * @return list of mobile  models sorted by relevance and release year.
     */
    @Query(value = "SELECT *, 0 as clazz_ FROM mobile m ORDER BY m.relevant DESC, m.release_year DESC", nativeQuery = true)
    @Override
    List<Mobile> findAll();

    /**
     * Sql query returns all {@code Mobile}, {@code MobileMainImage}, counts offers and returns minimal price.
     * All these values will be converted to {@code MobileDto}.
     * @return list of {@code MobileDto}
     */
    @Query(nativeQuery = true)
    List<MobileDto> findAllMobileDtos();
}
