package com.msa.service;

import com.msa.member.repository.MemberRepository;
import com.msa.member.service.MemberService;
import com.msa.post.service.PostService;
import com.msa.post.service.PostServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;


public class MemberServiceTest {
    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;

//    @BeforeEach
//    public void init() {
//        memberService = new memberService(memberRepository);
//    }

    @Test
    @DisplayName("add 시 repository 가 호출되는 지 확인")
    public void test_post_add() {
        memberService.addUser("username", "email", "password");
        verify(memberRepository, atLeastOnce()).save(any());
    }
}
