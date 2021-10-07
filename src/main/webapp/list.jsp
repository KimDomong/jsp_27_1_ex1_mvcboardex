<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <!-- ▼ jstl 쓸 수 있게 해주는 구문 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판 목록</title>
</head>
<body>
	<h2>게시판목록</h2>
	<table width="500" cellpaddig="0" cellspacing="0" border="1">
			<tr>
         		<td>번 호</td>
         		<td>제 목</td>
        		<td>이 름</td>
        		<td>날 짜</td>
        		<td>조회수</td>
			</tr>
		<c:forEach items="${list }" var="dto">
			<tr>
				<td>${dto.bid }</td>
				<td> <a href="content_view.do?bid=${dto.bid }">${dto.btitle }</a></td>
				<td>${dto.bname}</td>
				<td>${dto.bdate}</td>
				<td>${dto.bhit}</td>
			</tr>
		</c:forEach>
			<tr>
				<td colspan=5><a href="write_view.jsp">글작성</a></td>
			</tr>
	</table>
</body>
</html>