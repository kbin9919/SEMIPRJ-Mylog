package com.mylog.app.admin.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mylog.app.admin.member.service.AdminMemberService;
import com.mylog.app.admin.member.vo.AdminVo;

@WebServlet("/admin/login")
public class AdminLoginController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/admin/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			AdminVo vo = new AdminVo();
			vo.setEmail(email);
			vo.setPassword(password);
			System.out.println(vo);
			//service
			AdminMemberService as = new AdminMemberService();
			AdminVo loginAdminVo = as.adminLogin(vo);
			
			//result
			if(loginAdminVo == null) {
				throw new Exception();
			}
			HttpSession session = req.getSession();
			session.setAttribute("loginAdminVo", loginAdminVo);
			System.out.println(loginAdminVo);
			resp.sendRedirect("/Mylog/admin/main");
		}catch(Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/Mylog/admin/main");
		}
	
	}
}
