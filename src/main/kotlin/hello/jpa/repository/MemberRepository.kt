package hello.jpa.repository

import hello.jpa.domain.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member, Long>