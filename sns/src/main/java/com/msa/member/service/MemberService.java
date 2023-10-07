package com.msa.member.service;

import com.msa.member.domain.Member;
import com.msa.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member addUser(String userName, String email, String password) {
        Member member = new Member(userName, email, password, Set.of("USER"));
        return memberRepository.save(member);
    }
}
