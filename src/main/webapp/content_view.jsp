<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>content_view.jsp</title>
</head>
<body>
	<h2>�Խñ� ����</h2>
	<table width="500" cellpaddig="0" cellspacing="0" border="1">
			<form action="modify.do" method="post">
				<tr>
	         		<td align="center" width="15%">�� ȣ</td>
	         		<td align="center" width="20%">${content_view.bid }</td>
	         		<td align="center" width="15%">�� �� </td>
	         		<td align="center" >${content_view.btitle }</td>
	         	</tr>
	         	<tr>        		
	         		<td align="center" width="15%">�ۼ���</td>
	         		<td align="center" width="20%">${content_view.bname }</td>
	         		<td align="center" width="15%">��ȸ��</td>
	         		<td align="center">${content_view.bhit }</td>
	         		
				</tr>
				<tr>
					<td align="center">�� ��</td>
					<td colspan=3><textarea cols="90" name="bcontent" rows="10">${content_view.bcontent }</textarea></td>
				</tr>
				<tr>
					<td align="center">
					<input type="submit" value="�ۼ���">
					<td colspan=3 align="center">
						<a href="list.do">�۸��</a>&nbsp;&nbsp;&nbsp;
						<a href="">����</a>&nbsp;&nbsp;&nbsp;
						<a href="">���</a></td>
				</tr>
			</form>
	</table>
	
</body>
</html>