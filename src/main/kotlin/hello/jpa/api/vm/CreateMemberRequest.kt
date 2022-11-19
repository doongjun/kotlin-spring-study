package hello.jpa.api.vm

data class CreateMemberRequest(
    val name: String?,
    val city: String?,
    val street: String?,
    val zipcode: String?,
)
