<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%

	int num = Integer.parseInt(request.getParameter("no"));
	System.out.println(num);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>비밀번호 확인</h1>
	
	비밀번호<input type="text" name="password">
	
</body>
</html>