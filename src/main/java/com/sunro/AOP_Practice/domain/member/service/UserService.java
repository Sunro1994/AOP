package com.sunro.AOP_Practice.domain.member.service;

import com.sunro.AOP_Practice.domain.member.entity.Member;
import com.sunro.AOP_Practice.domain.member.respository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final MemberRepository memberRepository;


    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member save(Member member) {


        return memberRepository.save(member);
    }

    public void delete(Long id) {
        Optional<Member> findMember = memberRepository.findById(id);
        findMember.ifPresent(memberRepository::delete);

    }
}
