package hello.jpa.domain

import java.time.LocalDateTime
import javax.persistence.*
import javax.persistence.CascadeType.*
import javax.persistence.FetchType.*

@Entity
@Table(name = "orders")
class Order(
    @Id @GeneratedValue
    @Column(name = "order_id")
    val id: Long? = null,

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    var member: Member? = null,

    @OneToMany(mappedBy = "order", cascade = [ALL])
    val orderItems: MutableList<OrderItem> = mutableListOf(),

    @OneToOne(cascade = [ALL], fetch = LAZY)
    @JoinColumn(name = "delivery_id")
    var delivery: Delivery? = null,

    val orderDate: LocalDateTime? = null,

    @Enumerated(EnumType.STRING)
    var status: OrderStatus? = null
) {
    /* 연관관계 메서드 */

    @JvmName("setMemberCustom")
    fun setMember(member: Member) {
        this.member = member
        member.orders.add(this)
    }

    public fun addOrderItem(orderItem: OrderItem) {
        orderItems.add(orderItem)
        // TODO: set order
    }

    @JvmName("setDeliveryCustom")
    public fun setDelivery(delivery: Delivery) {
        this.delivery = delivery
        // TODO: set delivery
    }
}
