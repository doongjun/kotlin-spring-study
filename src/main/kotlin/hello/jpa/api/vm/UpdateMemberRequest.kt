package hello.jpa.api.vm

data class UpdateMemberRequest(
    val name: String?,
    val city: String?,
    val street: String?,
    val zipcode: String?,
)
