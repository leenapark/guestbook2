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
		
		request.setCharacterEncoding("UTF-8");
		
		
		// 파라미터로 액션 값을 읽음
		String action = request.getParameter("action");
		System.out.println("=====action======");
		System.out.println(action);
		
		
		
		// action = ? --> ?에 해당하는 일을 할 수 있는 코드 짜기
		
		
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
			
					
			response.sendRedirect("/guestbook2/gbc?action=addlist");
			
		} else if("dForm".equals(action)) {
			System.out.println("삭제 폼 처리");

			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/daleteForm.jsp");
			rd.forward(request, response);
			
			
		} else if("delete".equals(action)) {
			System.out.println("삭제 처리");
			
			int num = Integer.parseInt(request.getParameter("no"));
			String password = request.getParameter("password");
			//값이 잘 들어오고 있는지 확인
			System.out.println(num);
			System.out.println(password);
			
			GuestDao guestDao = new GuestDao();
			
			GuestVo check = guestDao.getInfo(num);
			
			// 기존 패스워드와 비교
			if(check.getPassword().equals(password)) {
				// 확인용 메세지 출력
				System.out.println("삭제");
				
				// 리스트 삭제
				guestDao.guestDelete(num);
				
				// 첫 화면으로 돌아가기
				response.sendRedirect("/guestbook2/gbc?action=addlist");

				
			} else {
				
				System.out.println("비밀번호가 틀렸습니다");
				
				response.sendRedirect("/guestbook2/gbc?action=addlist");
				
			}
						
			
		}
		
		
	}


	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()");
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
