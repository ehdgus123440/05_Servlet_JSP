package edu.kh.todolist.controller;

import java.io.IOException;

import edu.kh.todolist.dto.Todo;
import edu.kh.todolist.service.TodoListService;
import edu.kh.todolist.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/todo/update")
public class UpdateServlet extends HttpServlet{

	// 수정 화면 전환
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 전달 받은 파라미터 얻어오기
		int index = Integer.parseInt(req.getParameter("index"));
	
		try {
			// 수정 전 제목/내용 조회 == 상세조회
			TodoListService service = new TodoListServiceImpl();
			Todo todo = service.todoDetailView(index);
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
