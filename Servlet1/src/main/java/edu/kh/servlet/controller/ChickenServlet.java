package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/chicken")
public class ChickenServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String chicken = req.getParameter("chicken");
		String type = req.getParameter("type");

		String orderName = req.getParameter("orderName");
		String orderAddress = req.getParameter("orderAddress");

		String[] options = req.getParameterValues("opt");

		int price = 0;

		switch (chicken) {
		case "후라이드":
			price += 10000;
			break;
		case "간장", "마늘":
			price += 12000;
			break;
		case "양념":
			price += 11000;
			break;
		}
		
		if(type.equals("boneless")) price += 2000;
		
		if(options != null) {
			for(String opt : options) {
				switch (opt) {
				case "치킨무" : price += 500; break;
				case "콜라" : price += 2000; break;
				case "치즈볼" : price += 3000; break;
				}
			}
		}
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		StringBuilder sb = new StringBuilder();
		
		sb.append("""
		<!DOCTYPE html>
		<html>
		 <head>
		  <meta charset='utf-8'>
		  <title>""");
		
		sb.append(orderName + " 님의 주문 영수증");
		
		sb.append("</title>");
		sb.append("</head>");
		sb.append("<body>");
		
		sb.append("<h3> 주문자 명 : " + orderName + "</h3>");
		sb.append("<h3> 주문자 주소 : " + orderAddress + "</h3>");
		sb.append("<ul>");
			sb.append("<li>치킨 : " + chicken +"<li>");
			sb.append("<li>뼈/순살 : " + (type.equals("bone") ? "뼈" : "순살") +"<li>");
		
			if(options != null) {
				sb.append("<li>선택한 옵션 : " );
				
				// String 배열을 한 줄로 변환
				sb.append(String.join(" / ", options));
				
				sb.append("<li>");
			}
			
		sb.append("</ul>");
		
		sb.append("<h3>금액 : " + price + "</h3>");
		
		sb.append("</body>");
		sb.append("</html>");
		
		out.write(sb.toString());
	}
}
