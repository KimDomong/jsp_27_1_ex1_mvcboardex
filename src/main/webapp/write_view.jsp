<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խ��� �۾���</title>
</head>
<body>
	<h2>�����Խ���</h2>
	<table width="500" cellpaddig="0" cellspacing="0" border="1">
		<form action="write.do" method="post">
			<tr>
				<td>�� ��</td>
				<td><input type="text" name="bname" size="50"></td>
			</tr>
			<tr>
				<td>�� ��</td>
				<td><input type="text" name="btitle" size="50"></td>
			</tr>
			<tr>
				<td>�� ��</td>
				
				
				<!-- textarea = ���� �������� ��� -->
				<td><textarea name="bcontent" rows="10" cols="47"></textarea></td> 
			</tr>
			<tr>
				<td colspan = 2>>&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="������"><a href="list.do">�۾��� ���</a></td>
			</tr>
		</form>
	</table>
</body>
</html>