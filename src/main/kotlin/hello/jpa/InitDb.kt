package hello.jpa

import hello.jpa.domain.*
import hello.jpa.domain.item.Book
import hello.jpa.repository.ItemRepository
import hello.jpa.repository.MemberRepository
import hello.jpa.repository.OrderRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import javax.annotation.PostConstruct

@Component
class InitDb(
    private val initService: InitService
) {
    @PostConstruct
    fun init() {
        initService.dbInit1()
        initService.dbInit2()
    }

    companion object {
        @Component
        @Transactional
        class InitService(
            private val memberRepository: MemberRepository,
            private val itemRepository: ItemRepository,
            private val orderRepository: OrderRepository
        ) {
            fun dbInit1() {
                val member = Member(name = "userA", address = Address(city = "서울", street = "교대역", zipcode = "12345"))
                memberRepository.save(member)

                val book1 = Book(author = "작가", isbn = "123", name = "kotlin", price = 10000, stockQuantity = 100)
                val book2 = Book(author = "작가", isbn = "123", name = "spring", price = 20000, stockQuantity = 100)
                itemRepository.saveAll(listOf(book1, book2))

                val orderItem1 = OrderItem.createOrderItem(book1, 10000, 1)
                val orderItem2 = OrderItem.createOrderItem(book2, 20000, 2)

                val delivery = Delivery(address = member.address)

                val order = Order.createOrder(member = member, delivery = delivery, orderItem1, orderItem2)
                orderRepository.save(order)
            }

            fun dbInit2() {
                val member = Member(name = "userA", address = Address(city = "일산", street = "대화역", zipcode = "123123"))
                memberRepository.save(member)

                val book1 = Book(author = "작가", isbn = "123", name = "python", price = 20000, stockQuantity = 200)
                val book2 = Book(author = "작가", isbn = "123", name = "django", price = 40000, stockQuantity = 300)
                itemRepository.saveAll(listOf(book1, book2))

                val orderItem1 = OrderItem.createOrderItem(book1, 20000, 3)
                val orderItem2 = OrderItem.createOrderItem(book2, 40000, 4)

                val delivery = Delivery(address = member.address)

                val order = Order.createOrder(member = member, delivery = delivery, orderItem1, orderItem2)
                orderRepository.save(order)
            }
        }
    }

}