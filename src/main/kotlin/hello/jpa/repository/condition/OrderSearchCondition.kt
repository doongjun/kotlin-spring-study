package hello.jpa.repository.condition

import hello.jpa.domain.OrderStatus

data class OrderSearchCondition(
    val memberName: String? = null,
    val orderStatus: OrderStatus? = null
)