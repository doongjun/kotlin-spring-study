package hello.jpa.api

import hello.jpa.api.vm.SimpleOrderDto
import hello.jpa.domain.Order
import hello.jpa.repository.condition.OrderSearchCondition
import hello.jpa.repository.query.dto.OrderSimpleQueryDto
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

    @GetMapping("/v2/simple-orders")
    fun ordersV2(): List<SimpleOrderDto> =
        orderService.findByCriteria(OrderSearchCondition())
            .map { SimpleOrderDto(it) }

    @GetMapping("/v3/simple-orders")
    fun ordersV3(): List<OrderSimpleQueryDto> =
        orderService.findAll()

}