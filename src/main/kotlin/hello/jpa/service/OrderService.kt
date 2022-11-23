package hello.jpa.service

import hello.jpa.domain.Order
import hello.jpa.repository.OrderRepositoryCustom
import hello.jpa.repository.condition.OrderSearchCondition
import hello.jpa.repository.query.OrderQueryRepository
import hello.jpa.repository.query.dto.OrderSimpleQueryDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class OrderService(
    private val orderRepositoryCustom: OrderRepositoryCustom,
    private val orderQueryRepository: OrderQueryRepository
) {

    fun findByCriteria(
        orderSearchCondition: OrderSearchCondition
    ): List<Order> =
        orderRepositoryCustom.findByCriteria(orderSearchCondition)

    fun findByCriteriaFetch(
        orderSearchCondition: OrderSearchCondition
    ): List<Order> =
        orderRepositoryCustom.findByCriteriaFetch(orderSearchCondition)

    fun findAll(): List<OrderSimpleQueryDto> =
        orderQueryRepository.findOrderDtos()

}