package com.sunro.AOP_Practice.domain.member.entity;

import com.sunro.AOP_Practice.domain.member.constant.RoleType;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import static jakarta.persistence.GenerationType.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_login_id")
    private String LoginId;

    @Column(name = "member_password")
    private String Password;

    @Column(name = "member_name")
    private String name;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    public Member(long l, String johnDoe, String mail) {
        this.LoginId = johnDoe;
        this.Password = mail;
        this.name = johnDoe;

    }
}
