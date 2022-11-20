package hello.jpa.repository.query.dto

import com.querydsl.core.annotations.QueryProjection
import hello.jpa.domain.Address
import hello.jpa.domain.OrderStatus
import java.time.LocalDateTime

data class OrderSimpleQueryDto @QueryProjection constructor(
    val orderId: Long?,
    val name: String?,
    val orderDate: LocalDateTime?,
    val orderStatus: OrderStatus?,
    val address: Address?
)
