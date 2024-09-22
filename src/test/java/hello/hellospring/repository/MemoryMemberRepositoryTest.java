package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        memoryMemberRepository.clearStore();
    }


    @Test
    void save() {
        Member member = new Member();
        member.setName("spring");
        memoryMemberRepository.save(member);
        memoryMemberRepository.findById(member.getId()).get();

        Member result = memoryMemberRepository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);


    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memoryMemberRepository.save(member2);

        Member result = memoryMemberRepository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);

        assertThat(result).isNotEqualTo(member2);
    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memoryMemberRepository.save(member2);

        List<Member> members = memoryMemberRepository.findAll();

        assertThat(members.size()).isEqualTo(2);


    }
}