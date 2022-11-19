package hello.jpa.api.vm

import hello.jpa.domain.Member

data class MemberDto(
    val id: Long?,
    val name: String?,
    val city: String?,
    val street: String?,
    val zipcode: String?,
) {
    constructor(member: Member): this(
        id = member.id,
        name = member.name,
        city = member.address?.city,
        street = member.address?.street,
        zipcode = member.address?.zipcode
    )
}
