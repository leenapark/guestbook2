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
	<form action="/guestbook2/gbc" method="get">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value=""></td>
				<td>비밀번호</td>
				<td><input type="text" name="password" value=""></td>
			</tr>
			<tr>
				<td colspan="4"><textarea cols="65" rows="10" name="content"></textarea><td>
			</tr>
			<tr>
				<td colspan="4"><button type="submit" name="action" value="add">확인</button>
			</tr>
			
		</table>
	</form>
	
	
		<%for(int i=0; i<addList.size(); i++){ %>
	<table border="1">
		<tr>
			<td><input type="text" name="no" value="<%=addList.get(i).getNo() %>"> <%=addList.get(i).getNo() %> </td>
			<td> <%=addList.get(i).getName() %> </td>
			<td> <%=addList.get(i).getRegDate() %> </td>
			<td> <input type="button" name="action" value="delete"> 삭제 </td>
		</tr>
		<tr>
			<td colspan="5"><%=addList.get(i).getContent() %></td>
		</tr>
		<br>
	</table>
	<%} %>
	
</body>
</html>