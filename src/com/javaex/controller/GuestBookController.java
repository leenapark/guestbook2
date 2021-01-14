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
import com.javaex.util.WebUtil;
import com.javaex.vo.GuestVo;

@WebServlet("/gbc")
public class GuestBookController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 모두 사용 가능한 메소드 정리
		GuestDao guestDao = new GuestDao();

		
		// 컨트롤러 테스트
		System.out.println("controller");

		request.setCharacterEncoding("UTF-8");

		// 파라미터로 액션 값을 읽음
		String action = request.getParameter("action");
		System.out.println("=====action======");
		System.out.println(action);

		// action = ? --> ?에 해당하는 일을 할 수 있는 코드 짜기

		// action = addlist
		if ("add".equals(action)) {
			System.out.println("저장");

			// 방명록 받은 값 저장하기
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String content = request.getParameter("content");

			GuestVo guestVo = new GuestVo(name, password, content);

			guestDao.guestInsert(guestVo);

			// 리스트 만들기
			List<GuestVo> addList = guestDao.addList();

			// 데이터 전달
			// request.setAttribute("별명", 실제 데이터);
			request.setAttribute("aList", addList);

			/*
			response.sendRedirect("/guestbook2/gbc");
			WebUtil의 만들어둔 메소드로 대체
			*/
			WebUtil.redirect(request, response, "/guestbook2/gbc");
			
		} else if ("dForm".equals(action)) {

			System.out.println("삭제 폼 처리");
			
			WebUtil.forword(request, response, "./WEB-INF/daleteForm.jsp");

		} else if ("delete".equals(action)) {
			System.out.println("삭제 처리");
			/*
			 * 수정 전 no 값과 password 값을 각각 변수에 담아서 기존 패스워드와 비교해서 삭제처리를 했음
			 * int num = Integer.parseInt(request.getParameter("no"));
			 * String password = request.getParameter("password"); //값이 잘 들어오고 있는지 확인
			 * System.out.println(num);
			 * System.out.println(password);
			int check = guestDao.guestDelete(Integer.parseInt(request.getParameter("no")),
					request.getParameter("password"));

			 */
			
			
			int check = guestDao.guestDelete(Integer.parseInt(request.getParameter("no")),
					request.getParameter("password"));
			
			System.out.println(check);

			
			// 기존 패스워드와 비교
			if (check == 1) {
				// 확인용 메세지 출력
				System.out.println("삭제");

				// 첫 화면으로 돌아가기
				WebUtil.redirect(request, response, "/guestbook2/gbc");

				
			} else if (check == 0) {
				// 확인용 메세지 출력
				System.out.println("비밀번호가 틀렸습니다");
				
				String result = "fail";
				
				WebUtil.redirect(request, response, "/guestbook2/gbc?action=dForm&result=fail&no="+request.getParameter("no"));

			}

		} else {
			
			System.out.println("리스트");
				
			// 리스트 만들기
			List<GuestVo> addList = guestDao.addList();
			
			// 데이터 전달
			// request.setAttribute("별명", 실제 데이터);
			request.setAttribute("aList", addList);
			
			
			WebUtil.forword(request, response, "./WEB-INF/addList.jsp");
		}
		
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost()");
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
