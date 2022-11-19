package hello.jpa.domain

import javax.persistence.*
import javax.persistence.FetchType.*

@Entity
class Delivery(
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    val id: Long? = null,

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    val order: Order? = null,

    @Embedded
    var address: Address? = null,

    @Enumerated(EnumType.STRING)
    val status: DeliveryStatus? = null

)
