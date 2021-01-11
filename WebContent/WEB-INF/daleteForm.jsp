<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%

	int num = Integer.parseInt(request.getParameter("no"));
	System.out.println(num);		//파라미터로 가져온 정보가 잘 넘어오는지 확인
		
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>비밀번호 확인</h1>
	
	<form action="/guestbook2/gbc" method="post">
		비밀번호<input type="password" name="password">
		<button type="submit" name="action" value="delete">확인</button>
		<input type="hidden" name="no" value="<%=num %>">
		
	</form>
	<br>
	<a href="/guestbook2/gbc?action=addlist">메인으로 돌아가기</a>
	
</body>
</html>