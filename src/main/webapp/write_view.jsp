<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판 글쓰기</title>
</head>
<body>
	<h2>자유게시판</h2>
	<table width="500" cellpaddig="0" cellspacing="0" border="1">
		<form action="write.do" method="post">
			<tr>
				<td>이 름</td>
				<td><input type="text" name="bname" size="50"></td>
			</tr>
			<tr>
				<td>제 목</td>
				<td><input type="text" name="btitle" size="50"></td>
			</tr>
			<tr>
				<td>내 용</td>
				
				
				<!-- textarea = 줄이 여러줄일 경우 -->
				<td><textarea name="bcontent" rows="10" cols="47"></textarea></td> 
			</tr>
			<tr>
				<td colspan = 2>>&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="글저장"><a href="list.do">글쓰기 목록</a></td>
			</tr>
		</form>
	</table>
</body>
</html>