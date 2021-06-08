<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(int i=0; i<cookies.length; i++){
				out.println(cookies[i].getName() + ":");
				out.println(cookies[i].getValue() + "<br />");
			}
		}
	%>
	<hr>
	쿠키 값: ${cookie.JSESSIONID.value}<br>
	<hr>
	
	<a href="${pageContext.request.contextPath}/cookie/del">쿠키 삭제</a>

</body>
</html>

