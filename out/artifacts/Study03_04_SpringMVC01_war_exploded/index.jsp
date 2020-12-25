<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>

        <a href="hello?username=admin&password=123456">测试springMVC</a>
        <a href="/test">hello</a>
        <form action="/test" method="post">
            <input type="submit" value="hello">
        </form>
    </body>
</html>