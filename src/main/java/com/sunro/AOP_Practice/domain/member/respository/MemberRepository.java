package com.sunro.AOP_Practice.domain.member.respository;

import com.sunro.AOP_Practice.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long>  {
}
