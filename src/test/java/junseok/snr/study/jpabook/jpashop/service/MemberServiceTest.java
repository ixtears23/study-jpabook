package junseok.snr.study.jpabook.jpashop.service;

import junseok.snr.study.jpabook.jpashop.domain.Member;
import junseok.snr.study.jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    @Rollback(value = false)
    void 회원가입() throws Exception {
        Member member = new Member();
        member.setName("kim");

        final Long savedId = memberService.join(member);

        assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test
    void 중복_회원_예외() throws Exception {
        final Member member1 = new Member();
        member1.setName("oh1");

        final Member member2 = new Member();
        member2.setName("oh1");
        memberService.join(member1);

        final Exception exception = assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2);
        });

        assertEquals("이미 존재하는 회원입니다.", exception.getMessage());
    }

}