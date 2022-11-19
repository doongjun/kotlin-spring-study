package hello.jpa.domain

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Address(
    city: String,
    street: String,
    zipcode: String
) {
    constructor() : this("", "", "")

    @Column
    var city: String = city
        private set
    @Column
    var street: String = street
        private set
    @Column
    var zipcode: String = zipcode
        private set
}