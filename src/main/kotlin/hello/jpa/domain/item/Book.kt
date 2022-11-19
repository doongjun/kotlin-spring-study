package hello.jpa.domain.item

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("B")
class Book(
    var author: String? = null,
    var isbn: String? = null
): Item() {
    constructor(author: String?, isbn: String?, name: String?, price: Int, stockQuantity: Int): this(
        author = author,
        isbn = isbn
    ) {
        this.name = name
        this.price = price
        this.stockQuantity = stockQuantity
    }
}