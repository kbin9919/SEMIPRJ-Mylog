import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberDao memberDao;

    @Autowired
    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void addMember(MemberVO member) throws SQLException {
        memberDao.insertMember(member);
    }

    public MemberVO getMember(int no) throws SQLException {
        return memberDao.selectMember(no);
    }

    public List<MemberVO> getAllMembers() throws SQLException {
        return memberDao.selectAllMembers();
    }

    public void updateMember(MemberVO member) throws SQLException {
        memberDao.updateMember(member);
    }

    public void deleteMember(int no) throws SQLException {
        memberDao.deleteMember(no);
    }
}
