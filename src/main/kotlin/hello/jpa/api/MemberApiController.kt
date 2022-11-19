package hello.jpa.api

import hello.jpa.api.vm.CreateMemberRequest
import hello.jpa.api.vm.CreateMemberResponse
import hello.jpa.api.vm.UpdateMemberRequest
import hello.jpa.api.vm.UpdateMemberResponse
import hello.jpa.domain.Address
import hello.jpa.domain.Member
import hello.jpa.service.MemberService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class MemberApiController(
    private val memberService: MemberService
) {

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