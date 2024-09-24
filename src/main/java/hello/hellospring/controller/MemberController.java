package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {



/*    // Field Injection
    @Autowired private MemberService service;*/

    private final MemberService memberService;

    /*
    Setter Injection
    */
//    @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
