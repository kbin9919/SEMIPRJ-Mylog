import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public String getAllMembers(Model model) throws SQLException {
        List<MemberVO> members = memberService.getAllMembers();
        model.addAttribute("members", members);
        return "members";
    }

    @GetMapping("/add")
    public String addMemberForm() {
        return "addMember";
    }

    @PostMapping("/add")
    public String addMember(@ModelAttribute MemberVO member) throws SQLException {
        memberService.addMember(member);
        return "redirect:/members";
    }

    @GetMapping("/edit/{no}")
    public String editMemberForm(@PathVariable int no, Model model) throws SQLException {
        MemberVO member = memberService.getMember(no);
        model.addAttribute("member", member);
        return "editMember";
    }

    @PostMapping("/edit/{no}")
    public String editMember(@PathVariable int no, @ModelAttribute MemberVO member) throws SQLException {
        member.setNo(no);
        memberService.updateMember(member);
        return "redirect:/members";
    }

    @GetMapping("/delete/{no}")
    public String deleteMember(@PathVariable int no) throws SQLException {
        memberService.deleteMember(no);
        return "redirect:/members";
    }
}
