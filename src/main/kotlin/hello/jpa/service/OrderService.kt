package hello.jpa.service

import hello.jpa.domain.Order
import hello.jpa.repository.OrderRepositoryCustom
import hello.jpa.repository.condition.OrderSearchCondition
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class OrderService(
    private val orderRepositoryCustom: OrderRepositoryCustom
) {

    fun findByCriteria(
        orderSearchCondition: OrderSearchCondition
    ): List<Order> =
        orderRepositoryCustom.findByCriteria(orderSearchCondition)

}