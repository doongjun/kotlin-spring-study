package hello.jpa.api

import hello.jpa.api.vm.CreateMemberRequest
import hello.jpa.api.vm.CreateMemberResponse
import hello.jpa.domain.Member
import hello.jpa.service.MemberService
import org.springframework.web.bind.annotation.PostMapping
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
    ): CreateMemberResponse =
        CreateMemberResponse(
            id = memberService.join(Member(name = request.name))
        )

}