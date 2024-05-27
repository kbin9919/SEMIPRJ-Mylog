package com.mylog.app.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mylog.app.admin.service.AdminService;
import com.mylog.app.admin.vo.AdminVo;

@WebServlet("/admin/login")
public class AdminLoginController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
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
			
			//service
			AdminService as = new AdminService();
			AdminVo loginAdminVo = as.login(vo);
			
			//result
			if(loginAdminVo == null) {
				throw new Exception();
			}
			HttpSession session = req.getSession();
			session.setAttribute("loginAdminVo", loginAdminVo);
			
//			PrintWriter out = resp.getWriter();
//			out.write("관리자 로그인 성공! : " + loginAdminVo);
//			resp.sendRedirect("/app/home");
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}
