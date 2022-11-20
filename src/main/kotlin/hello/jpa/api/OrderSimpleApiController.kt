package hello.jpa.api

import hello.jpa.domain.Order
import hello.jpa.repository.OrderRepository
import hello.jpa.repository.OrderRepositoryCustom
import hello.jpa.repository.condition.OrderSearchCondition
import hello.jpa.service.OrderService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * XToOne
 */
@RestController
@RequestMapping("/api")
class OrderSimpleApiController(
    private val orderService: OrderService
) {

    @GetMapping("/v1/simple-orders")
    fun ordersV1(): List<Order> =
        orderService.findByCriteria(OrderSearchCondition())

}