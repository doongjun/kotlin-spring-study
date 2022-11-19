package hello.jpa.domain

import hello.jpa.domain.item.Item
import javax.persistence.*
import javax.persistence.FetchType.*

@Entity
@Table(name = "order_item")
class OrderItem(
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    val id: Long? = null,

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    var item: Item? = null,

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    var order: Order? = null,

    var orderPrice: Int = 0,
    val count: Int = 0
) {
    companion object {
        fun createOrderItem(item: Item, orderPrice: Int, count: Int): OrderItem {
            item.removeStock(count)
            return OrderItem(
                item = item,
                orderPrice = orderPrice,
                count = count
            )
        }
    }
}
