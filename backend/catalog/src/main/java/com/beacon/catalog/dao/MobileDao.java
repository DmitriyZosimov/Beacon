package com.beacon.catalog.dao;

import com.beacon.model.MobileDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Dao class is to manipulate with mobile data in database.
 */
@Repository
public interface MobileDao extends JpaRepository<MobileDto, String> {

    /**
     * JPA has only three strategies of inheritance. And the strategy does not exist among them which allow to get only
     * values of superclass. It has to modify one of them. JOINED strategy is used by default (see {@link MobileDto}).
     * Hibernate uses a value "clazz_" to determine subclasses of our superclass:
     * <p>
     * Hibernate:
     * select mobiledtof0_.mobile_id as mobile_i1_0_0_, mobiledtof0_1_.battery as battery2_0_0_,<...></...>
     * case
     * when mobiledto0_1_.mobile_id is not null
     * then 1
     * when mobiledto0_.mobile_id is not null
     * then 0
     * end as clazz_
     * from mobile_dto mobiledto0_ left outer join mobile_dto_full mobiledto0_1_
     * on mobiledto0_.mobile_id=mobiledto0_1_.mobile_id
     * <p>
     * In case only superclass values is needed, clazz_ value must be explicitly input as 0.
     * To resolve this situation a native sql should be used.
     *
     * @return list of mobile dto models
     */
    @Query(value = "SELECT *, 0 as clazz_ FROM mobile_dto", nativeQuery = true)
    @Override
    List<MobileDto> findAll();
}
