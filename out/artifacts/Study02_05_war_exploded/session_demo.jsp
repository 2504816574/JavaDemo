<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	sessionId:<%=session.getId() %><br>
	<a href="${pageContext.request.contextPath}/GetSessionServlet">获取Session</a><br>
	<a href="${pageContext.request.contextPath}/ChiSessionServlet">持久化Session</a><br>
	<a href="${pageContext.request.contextPath}/ShiSessionServlet">设置Session立即失效</a><br>
	student:<%=session.getAttribute("stu") %>
</body>
</html>