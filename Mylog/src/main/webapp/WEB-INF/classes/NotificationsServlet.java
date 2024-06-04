@WebServlet("/notifications")
public class NotificationsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));

        // 데이터베이스 연결 및 알림 조회
        List<Notification> notifications = new ArrayList<>();
        try {
            Context initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/yourDB");
            Connection conn = ds.getConnection();

            String getNotificationsSQL = "SELECT * FROM notifications WHERE user_id = ? ORDER BY created_at DESC";
            PreparedStatement pst = conn.prepareStatement(getNotificationsSQL);
            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Notification notification = new Notification();
                notification.setId(rs.getInt("id"));
                notification.setUserId(rs.getInt("user_id"));
                notification.setType(rs.getString("type"));
                notification.setTargetId(rs.getInt("target_id"));
                notification.setMessage(rs.getString("message"));
                notification.setCreatedAt(rs.getTimestamp("created_at"));
                notifications.add(notification);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("notifications", notifications);
        RequestDispatcher dispatcher = request.getRequestDispatcher("notifications.jsp");
        dispatcher.forward(request, response);
    }
}