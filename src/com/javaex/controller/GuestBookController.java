package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;


@WebServlet("/gbc")
public class GuestBookController extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 컨트롤러 테스트
		//System.out.println("controller");
		
		// 파라미터로 액션 값을 읽음
		String action = request.getParameter("action");
		System.out.println("=====action======");
		System.out.println(action);
		
		
		// action = ? --> ?에 해당하는 일을 할 수 있는 코드 짜기
		
		//response.sendRedirect("./WEB-INF/addList.jsp");
		
		/*
		RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/addList.jsp");
		rd.forward(request, response);
		*/
		// action = addlist
		if ("addlist".equals(action)) {
			System.out.println("리스트");
			
			GuestDao guestDao = new GuestDao();
			
			// 리스트 만들기
			List<GuestVo> addList = guestDao.addList();
			
			// 데이터 전달
			// request.setAttribute("별명", 실제 데이터);
			request.setAttribute("aList", addList);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/addList.jsp");
			rd.forward(request, response);
			
			
			
		} else if("add".equals(action)) {
			System.out.println("저장");
			
			
			// 방명록 받은 값 저장하기
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String content = request.getParameter("content");
			
			
			GuestVo guestVo = new GuestVo(name, password, content);
			GuestDao guestDao = new GuestDao();
			
			guestDao.guestInsert(guestVo);
			
			// 리스트 만들기
			List<GuestVo> addList = guestDao.addList();
			
			// 데이터 전달
			// request.setAttribute("별명", 실제 데이터);
			request.setAttribute("aList", addList);
			
			/*
			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/addList.jsp");
			rd.forward(request, response);
			*/
			response.sendRedirect("/phonebook2/pbc?action=addlist");
			
		} else if("delete".equals(action)) {
			System.out.println("삭제 처리");
		}
		
		
	}


	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
