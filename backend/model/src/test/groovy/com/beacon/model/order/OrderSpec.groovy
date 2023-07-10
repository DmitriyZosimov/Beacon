package com.beacon.model.order

import com.beacon.model.H2Config
import com.beacon.model.builders.MobileFullBuilder
import com.beacon.model.builders.ShopBuilder
import com.beacon.model.builders.TaskBuilder
import spock.lang.Shared
import spock.lang.Specification

class OrderSpec extends Specification {

    @Shared
    Order order;
    @Shared
    def orders = new HashSet()

    @Shared
    def session = H2Config.getSession()

    def setupSpec() {
        def mobile = MobileFullBuilder.create().setMobileId("mobile").setBrand("brand").setReleaseYear("2022").build()
        def shop = ShopBuilder.create().name("name").build()
        def task = TaskBuilder.create().withFirstName("Alex")
                .withLastName("Smith")
                .withEmail("test@test.com")
                .withPhoneNumber("+1111111111")
                .withCity("LA")
                .withStreet("Street")
                .withComment("Comment")
                .build()
        order = Order.builder()
                .mobileId("mobile").mobile(mobile).shopId(1L).task(task).price(100).count(1).build()
//        task.setOrders(List.of(order))
        orders.add(order)

        def transaction = session.beginTransaction()
        session.persist(mobile)
        session.persist(shop)
        session.persist(task)
        session.flush()
        transaction.commit()
    }

    def 'A: orders contain this order'() {
        expect:
        orders.contains(order)
    }

    def 'B: orders contain order when persist then success'() {
        def transaction = session.beginTransaction()

        expect:
        order.getOrderId() == null

        when:
        session.persist(order)
        session.flush()
        transaction.commit()

        then:
        order.getOrderId() != null
        orders.contains(order)
    }

    def 'C: orders contain order when merge'() {
        def transaction = session.beginTransaction()
        order.setPrice(200)

        expect:
        orders.contains(order)

        when:
        Order mergedOrder = session.merge(order)
        session.flush()
        transaction.commit()

        then:
        orders.contains(mergedOrder)
    }

    def 'D: orders contain order when find'() {
        def transaction = session.beginTransaction()

        when:
        Order foundOrder = session.find(Order, order.getOrderId())
        session.flush()
        transaction.commit()

        then:
        orders.contains(foundOrder)
    }

    def 'E: orders contain order when detach'() {
        def transaction = session.beginTransaction()

        when:
        def foundOrder = session.find(Order, order.getOrderId())
        session.detach(foundOrder)
        transaction.commit()

        then:
        orders.contains(foundOrder)
    }

    def 'F: orders contain order when remove'() {
        def transaction = session.beginTransaction()

        when:
        Order foundOrder = session.find(Order, order.getOrderId())
        session.remove(foundOrder)
        session.flush()
        transaction.commit()

        then:
        orders.contains(foundOrder)
        orders.remove(foundOrder)
        !orders.contains(foundOrder)
    }
}
