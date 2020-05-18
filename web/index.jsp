<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
  request.getRequestDispatcher("/CRUDStudent?methodName=listStudent").forward(request, response);
%>
</html>
