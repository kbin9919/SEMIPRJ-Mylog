import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class EditMemberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int no = Integer.parseInt(request.getParameter("no"));
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

            // 업데이트 SQL 작성
            String sql = "UPDATE MEMBER SET EMAIL = ?, PASSWORD = ?, NICK = ?, INTRODUCTION = ?, ADMIN_YN = ? WHERE NO = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.setString(3, nick);
            pstmt.setString(4, introduction);
            pstmt.setString(5, adminYn);
            pstmt.setInt(6, no);

            // 업데이트 실행
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Member details updated successfully.");
            } else {
                System.out.println("Failed to update member details.");
            }

            // 리다이렉션 
            response.sendRedirect("memberDetails.jsp?no=" + no);
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
