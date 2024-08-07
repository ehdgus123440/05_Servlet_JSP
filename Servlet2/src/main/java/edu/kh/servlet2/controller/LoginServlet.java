package edu.kh.servlet2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 해당 클래스를 Servlet으로 등록 + "/login" 요청 주소로 처리하도록 매핑
// (html의 form태그 action값)
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	// login post 방식 요청을 처리하는 메서드
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//요청시 제출된 값(파라미터) 모두 얻어오기
		String inputId = req.getParameter("inputId");
		String inputPw = req.getParameter("inputPw");
		String check   = req.getParameter("check");

		// id = user01, pw = pass01, check = 헬로 월드
		String result = "";
		
		if(inputId.equals("user01") && inputPw.equals("pass01") && check.equals("헬로 월드")) {
			result = "<h1 style='color:red;'>로그인 성공</h1>";
		}
		else {
			if(!inputId.equals("user01")) {
				result += "<h3>ID가 일치하지 않습니다</h3>";
			}
			if(!inputPw.equals("pass01")) {
				result += "<h3>PW가 일치하지 않습니다</h3>";
			}
			if(!check.equals("헬로 월드")) {
				result += "<h3>CHECK가 일치하지 않습니다</h3>";
			}
		}
		
		// 응답되는 문서의 형식, 문자 인코딩 지정
		resp.setContentType("text/html; charset=utf-8");
		
		// 클라이언트와 연결된 출력용 스트림 얻어오기
		PrintWriter out = resp.getWriter();
		
		// 출력할 html 작성하기
		StringBuilder sb = new StringBuilder();
		
		sb.append("""
		<!DOCTYPE html>
		<html>
		 <head>
		  <title>로그인 결과 페이지</title>
		 </head>
		 <body>""");
		
		sb.append(result);
		sb.append("</body>");
		sb.append("</html>");
		
		out.write(sb.toString());
		
	}
	
}
