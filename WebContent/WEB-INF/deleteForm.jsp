<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>비밀번호 확인</h1>

	<c:if test="${result == fail}">
		<p>비밀 번호가 틀렸습니다. 다시 입력해주세요.</p>
	</c:if>
	
	<form action="/guestbook2/gbc" method="post">
		비밀번호<input type="password" name="password">
		<button type="submit" name="action" value="delete">확인</button>
		<input type="hidden" name="no" value="${param.no }">
		
	</form>
	<br>
	<a href="/guestbook2/gbc?action=addlist">메인으로 돌아가기</a>
	
</body>
</html>