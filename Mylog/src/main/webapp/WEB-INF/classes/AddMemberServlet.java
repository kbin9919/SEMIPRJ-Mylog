import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddMemberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String nick = request.getParameter("nick");
        String introduction = request.getParameter("introduction");
        String adminYn = request.getParameter("adminYn");

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 데이터베이스 연결
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "yourDBUser", "yourDBPassword");

            // 삽입 SQL 작성
            String sql = "INSERT INTO MEMBER (EMAIL, PASSWORD, NICK, INTRODUCTION, ADMIN_YN, ENROLL_DATE) VALUES (?, ?, ?, ?, ?, SYSDATE)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.setString(3, nick);
            pstmt.setString(4, introduction);
            pstmt.setString(5, adminYn);

            // 삽입 실행
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Member added successfully.");
            } else {
                System.out.println("Failed to add member.");
            }

            // 리다이렉션 (예: 회원 목록 페이지로)
            response.sendRedirect("memberList.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
