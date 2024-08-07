package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/* 별도 처리 없이 바로 JSP로 요청 위임 */
		
		// 1. 요청 위임할 JPS 경로 작성
		String path = "/WEB-INF/views/signup_result.jsp";
		
		// 2. 요청을 위임 시켜줄 객체 얻어오기
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher(path);
		
		// 3. HttpServletRequest/Response 두 객체를 JSP에 넘기기
		dispatcher.forward(req, resp);
		
		
	
	}
	
}
