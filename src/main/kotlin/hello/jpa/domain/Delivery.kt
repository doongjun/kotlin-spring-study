package hello.jpa.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import javax.persistence.FetchType.*

@Entity
class Delivery(
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    val id: Long? = null,

    @JsonIgnore
    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    var order: Order? = null,

    @Embedded
    var address: Address? = null,

    @Enumerated(EnumType.STRING)
    val status: DeliveryStatus? = null

)
