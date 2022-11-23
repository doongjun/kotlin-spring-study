package hello.jpa.repository

import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import hello.jpa.domain.Order
import hello.jpa.domain.OrderStatus
import hello.jpa.domain.QOrder.order
import hello.jpa.repository.condition.OrderSearchCondition
import org.springframework.stereotype.Repository
import org.springframework.util.StringUtils.hasText

@Repository
class OrderRepositoryCustom(
    private val queryFactory: JPAQueryFactory
) {

    fun findByCriteria(
        orderSearchCondition: OrderSearchCondition
    ): List<Order> =
        queryFactory
            .select(order)
            .from(order)
            .innerJoin(order.member).fetchJoin()
            .innerJoin(order.delivery).fetchJoin()
            .where(
                orderStatusEq(orderSearchCondition.orderStatus),
                memberNameContains(orderSearchCondition.memberName)
            )
            .fetch()

    fun findByCriteriaFetch(
        orderSearchCondition: OrderSearchCondition
    ): List<Order> = queryFactory
        .select(order)
        .distinct()
        .from(order)
        .innerJoin(order.member).fetchJoin()
        .innerJoin(order.delivery).fetchJoin()
        .leftJoin(order.orderItems).fetchJoin()
        .where(
            orderStatusEq(orderSearchCondition.orderStatus),
            memberNameContains(orderSearchCondition.memberName)
        )
        .fetch()

    private fun orderStatusEq(orderStatus: OrderStatus?): BooleanExpression? =
        orderStatus?.let { order.status.eq(it) }

    private fun memberNameContains(memberName: String?): BooleanExpression? =
        if(hasText(memberName)) {
            order.member.name.contains(memberName)
        } else {
            null
        }

}