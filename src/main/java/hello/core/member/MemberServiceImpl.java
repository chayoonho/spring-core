package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    // 생성자를 통해서 어떤 구현 객체를 주입할지는 오직 외부(AppConfig)에서 결정됨
    // 외존관계에 대한 고민은 외부에 맡기고, 실행에만 집중
    @Autowired // ac.getBean(MemberRepository.class) 같은 타입을 찾아서 먼저 주입(첫번째 조회 전략)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //for test
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
