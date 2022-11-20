package hello.jpa.repository.query

import com.querydsl.jpa.impl.JPAQueryFactory
import hello.jpa.domain.QDelivery.delivery
import hello.jpa.domain.QMember.member
import hello.jpa.domain.QOrder.order
import hello.jpa.repository.dto.QOrderSimpleQueryDto
import hello.jpa.repository.query.dto.OrderSimpleQueryDto
import org.springframework.stereotype.Repository

@Repository
class OrderQueryRepository(
    private val queryFactory: JPAQueryFactory
) {

    fun findOrderDtos(): List<OrderSimpleQueryDto> =
        queryFactory
            .select(
                QOrderSimpleQueryDto(
                    order.id,
                    order.member.name,
                    order.orderDate,
                    order.status,
                    order.delivery.address
                )
            )
            .from(order)
            .innerJoin(order.member, member)
            .innerJoin(order.delivery, delivery)
            .fetch()

}