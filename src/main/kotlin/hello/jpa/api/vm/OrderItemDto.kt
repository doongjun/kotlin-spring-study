package hello.jpa.api.vm

import hello.jpa.domain.OrderItem

data class OrderItemDto(
    val itemName: String?,
    val orderPrice: Int?,
    val count: Int?
) {
    constructor(orderItem: OrderItem): this(
        itemName = orderItem.item?.name,
        orderPrice = orderItem.orderPrice,
        count = orderItem.count
    )
}
