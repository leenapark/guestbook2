<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	
	<%for(int i=0; i<addList.size(); i++){ %>
		<table border="1">
			<tr>
				<td> <%=addList.get(i).getNo() %> </td>
				<td> <%=addList.get(i).getName() %> </td>
				<td> <%=addList.get(i).getRegDate() %> </td>
				<td><a href="/guestbook2/gbc?action=dForm&no=<%=addList.get(i).getNo() %>">삭제 </a></td>
			</tr>
			<tr>
				<td colspan="5"><%=addList.get(i).getContent() %> </td>
			</tr>
		</table>
		<br>
	<%} %>
	
</body>
</html>