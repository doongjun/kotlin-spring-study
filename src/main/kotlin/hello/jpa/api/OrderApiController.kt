package hello.jpa.api

import hello.jpa.api.vm.OrderDto
import hello.jpa.repository.condition.OrderSearchCondition
import hello.jpa.service.OrderService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class OrderApiController(
    private val orderService: OrderService
) {

    @GetMapping("/v1/orders")
    fun ordersV1(): List<OrderDto> =
        orderService.findByCriteria(OrderSearchCondition())
            .map { OrderDto(it) }

    @GetMapping("/v2/orders")
    fun ordersV2(): List<OrderDto> =
        orderService.findByCriteriaFetch(OrderSearchCondition())
            .map { OrderDto(it) }

    @GetMapping("/v2.1/orders")
    fun ordersV2_page(): List<OrderDto> =
        orderService.findByCriteria(OrderSearchCondition())
            .map { OrderDto(it) }


}
