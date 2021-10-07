<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>content_view.jsp</title>
</head>
<body>
	<h2>게시글 내용</h2>
	<table width="500" cellpaddig="0" cellspacing="0" border="1">
			<form action="modify.do" method="post">
				<tr>
	         		<td align="center" width="15%">번 호</td>
	         		<td align="center" width="20%">${content_view.bid }</td>
	         		<td align="center" width="15%">제 목 </td>
	         		<td align="center" >${content_view.btitle }</td>
	         	</tr>
	         	<tr>        		
	         		<td align="center" width="15%">작성자</td>
	         		<td align="center" width="20%">${content_view.bname }</td>
	         		<td align="center" width="15%">조회수</td>
	         		<td align="center">${content_view.bhit }</td>
	         		
				</tr>
				<tr>
					<td align="center">내 용</td>
					<td colspan=3><textarea cols="90" name="bcontent" rows="10">${content_view.bcontent }</textarea></td>
				</tr>
				<tr>
					<td align="center">
					<input type="submit" value="글수정">
					<td colspan=3 align="center">
						<a href="list.do">글목록</a>&nbsp;&nbsp;&nbsp;
						<a href="">삭제</a>&nbsp;&nbsp;&nbsp;
						<a href="">댓글</a></td>
				</tr>
			</form>
	</table>
	
</body>
</html>