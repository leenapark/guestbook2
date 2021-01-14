<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="com.javaex.vo.GuestVo" %>
    
<%
	
	List<GuestVo> addList = (List<GuestVo>)request.getAttribute("aList");
	System.out.println("=====list.jsp======");
	System.out.println(addList);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/guestbook2/gbc" method="post">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value=""></td>
				<td>비밀번호</td>
				<td><input type="password" name="password" value=""></td>
			</tr>
			<tr>
				<td colspan="4"><textarea cols="65" rows="10" name="content"></textarea><td>
			</tr>
			<tr>
				<td colspan="4"><button type="submit">확인</button></td>
			</tr>
			
		</table>
		<input type="hidden" name="action" value="add">
		<br>
	</form>
	
	
	<c:forEach items="${aList}" var="list" >
		<table border="1">	
			<tr>
				<td> ${list.no } </td>
				<td> ${list.name }</td>
				<td> ${list.regDate }</td>
				<td><a href="/guestbook2/gbc?action=dForm&no=${list.no }">삭제 </a></td>
			</tr>
			<tr>
				<td colspan="5">${list.content } </td>
			</tr>
		</table>
		<br>
	</c:forEach>

</body>
</html>