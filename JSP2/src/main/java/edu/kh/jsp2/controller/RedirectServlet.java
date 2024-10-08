package edu.kh.jsp2.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/fr/redirect")
public class RedirectServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// requset scope에 값 추가
		req.setAttribute("str2", "가나다라마바사");
		
		HttpSession session = req.getSession();
		session.setAttribute("sessionNum", 10000);
		
		// resp.sendRedirect("다시 요청할 Servlet 주소")
		// 다시 요청할 Servlet의 @WebServlet()에 작성될 주소
		resp.sendRedirect("/fr/result");
		
	}
	
}
