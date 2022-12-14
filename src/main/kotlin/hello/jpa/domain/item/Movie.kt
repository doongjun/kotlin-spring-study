package hello.jpa.domain.item

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("M")
class Movie(
    var director: String? = null,
    var actor: String? = null
): Item()