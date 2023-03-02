package com.beacon.shop.dao;

import com.beacon.model.shop.Shop;
import com.beacon.shop.config.DaoConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@ContextConfiguration(classes = DaoConfiguration.class)
public class ShopDaoIT implements TestShopBuilder {

    @Autowired
    private ShopDao dao;

    @Autowired
    private DataSource dataSource;

    @Test
    public void setup() {
        Assertions.assertNotNull(dataSource);
    }

    @Test
    public void shouldReturnAllShops() {
        List<Shop> shops = dao.findAll();
        Assertions.assertEquals(7, shops.size());
        checkDefaultValuesFromImportSql(shops.get(0), shops.get(1), shops.get(2), shops.get(3), shops.get(4), shops.get(5), shops.get(6));
    }

    @Test
    public void shouldReturnShopById() {
        Optional<Shop> shop = dao.findById(2L);
        Assertions.assertTrue(shop.isPresent());
        checkDefaultValuesFromImportSql(shop.get());
    }

    @Test
    public void shouldSaveShop() {
        Shop shop = dao.saveAndFlush(build());
        Assertions.assertNotNull(shop.getShopId());
        Assertions.assertNotNull(shop.getLogo().getLogoId());
        shop.getWorkingHoursMap().forEach((dayOfWeek, hours) -> Assertions.assertNotNull(hours.getId()));
    }


}
