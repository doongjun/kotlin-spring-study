package hello.jpa.api.vm

import hello.jpa.domain.Address
import hello.jpa.domain.Order
import hello.jpa.domain.OrderStatus
import java.time.LocalDateTime

data class SimpleOrderDto(
    val orderId: Long?,
    val name: String?,
    val orderDate: LocalDateTime?,
    val orderStatus: OrderStatus?,
    val address: Address?
) {
    constructor(order: Order): this(
        orderId = order.id,
        name = order.member?.name,
        orderDate = order.orderDate,
        orderStatus = order.status,
        address = order.delivery?.address
    )
}
