<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="style/style.css" type="text/css">
<!DOCTYPE html>
<html>
    <head>
        <title>To Do list</title>
    </head>
    <body>
        <div class="section">
            <%@include file="jsp/new-task.jsp" %>
            <%@include file="jsp/error.jsp" %>
        </div>
        <%@include file="jsp/tasks.jsp" %>
    </body>
</html>