package hello.jpa.api.vm

data class UpdateMemberResponse(
    val id: Long?,
    val name: String?,
    val city: String?,
    val street: String?,
    val zipcode: String?
)
