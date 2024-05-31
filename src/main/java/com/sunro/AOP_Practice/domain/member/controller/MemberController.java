package com.sunro.AOP_Practice.domain.member.controller;

import com.sunro.AOP_Practice.domain.member.entity.Member;
import com.sunro.AOP_Practice.domain.member.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class MemberController {

    private final UserService memberService;

    @GetMapping
    public List<Member> getAllUsers() {
        return memberService.findAll();
    }

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberService.save(member);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.delete(id);
    }
}
