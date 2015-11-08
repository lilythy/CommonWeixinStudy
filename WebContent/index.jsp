<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE>汉广</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">

<script type="text/javascript">
	function login() {
		var fo = document.loginForm
		
		fo.action="<%=path%>/servlet/LoginAction";
		fo.submit;
	}
</script>

</HEAD>
<BODY>
       南有乔木，不可休息。汉有游女，不可求思。汉之广矣，不可泳思。江之永矣，不可方思。
　　翘翘错薪，言刈其楚。之子于归，言秣其马。汉之广矣，不可泳思。江之永矣，不可方思。
　　翘翘错薪，言刈其蒌。之子于归。言秣其驹。汉之广矣，不可泳思。江之永矣，不可方思。

	<a href="<%=path %>/province.jsp">省分数线</a>

	
	<form name="loginForm" method="post">
		<table>
			<tbody>
				<tr>
					<td>
						<input name="username" />
					</td>
					<td>
						<input name="password" type="password" />
					</td>
					<td>
						<input type="submit" onclick="login()" value="登录" />
					</td>
				</tr>			
			</tbody>
		</table>
	
	</form>
	
</BODY>
</HTML>

