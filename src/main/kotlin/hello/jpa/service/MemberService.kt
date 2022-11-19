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
    fun findOne(id: Long): Member =
        memberRepository.findById(id).orElseThrow()

    fun join(member: Member): Long =
        memberRepository.save(member).id!!

    fun update(id: Long, name: String?) {
        val member: Member = memberRepository.findById(id).orElseThrow()
        member.name = name
    }

}