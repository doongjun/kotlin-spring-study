package hello.jpa.api

import hello.jpa.api.vm.*
import hello.jpa.domain.Address
import hello.jpa.domain.Member
import hello.jpa.service.MemberService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class MemberApiController(
    private val memberService: MemberService
) {

    @GetMapping("/v1/members")
    fun membersV1(): List<Member> =
        memberService.findMembers()

    @GetMapping("/v2/members")
    fun membersV2(): Result<List<MemberDto>> =
        Result(
            data = memberService.findMembers().map { MemberDto(it) }
        )

    @PostMapping("/v1/members")
    fun saveMemberV1(
        @RequestBody @Valid member: Member
    ): CreateMemberResponse =
        CreateMemberResponse(id = memberService.join(member))

    @PostMapping("/v2/members")
    fun saveMemberV2(
        @RequestBody @Valid request: CreateMemberRequest
    ): CreateMemberResponse {
        val address = Address(city = request.city, street = request.street, zipcode = request.zipcode)
        return CreateMemberResponse(
            id = memberService.join(
                Member(
                    name = request.name,
                    address = address
                )
            )
        )
    }

    @PutMapping("/v2/members/{id}")
    fun updateMemberV2(
        @PathVariable("id") id: Long,
        @RequestBody @Valid request: UpdateMemberRequest
    ): UpdateMemberResponse {
        memberService.update(
            id,
            request.name,
            request.city,
            request.street,
            request.zipcode
        )
        val findMember = memberService.findOne(id)
        return UpdateMemberResponse(
            id = findMember.id,
            name = findMember.name,
            city = findMember.address?.city,
            street = findMember.address?.street,
            zipcode = findMember.address?.zipcode
        )
    }

}