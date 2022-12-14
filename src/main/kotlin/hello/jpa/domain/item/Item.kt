package hello.jpa.domain.item

import com.fasterxml.jackson.annotation.JsonIgnore
import hello.jpa.domain.Category
import hello.jpa.exception.NotEnoughStockException
import javax.persistence.Column
import javax.persistence.DiscriminatorColumn
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.ManyToMany

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
open class Item(
    @Id @GeneratedValue
    @Column(name = "item_id")
    open val id: Long? = null,

    open var name: String? = null,
    open var price: Int = 0,
    open var stockQuantity: Int = 0,

    @JsonIgnore
    @ManyToMany(mappedBy = "items")
    open val categories: List<Category> = listOf(),
) {
    fun addStock(quantity: Int) {
        this.stockQuantity += quantity
    }

    fun removeStock(quantity: Int) {
        val restStock = this.stockQuantity - quantity
        if(restStock < 0) {
            throw NotEnoughStockException("need more stock")
        }
        this.stockQuantity = restStock
    }

}