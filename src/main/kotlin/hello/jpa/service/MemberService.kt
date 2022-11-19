package hello.jpa.service

import hello.jpa.domain.Member
import hello.jpa.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MemberService(
    private val memberRepository: MemberRepository
) {

    fun join(member: Member): Long =
        memberRepository.save(member).id!!

}