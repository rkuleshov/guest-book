<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">

    <script src="<c:url value="/resources/js/jquery-1.11.2.min.js" />"></script>
    <script src="<c:url value="/resources/js/main.js" />"></script>

    <span style="float: right">
    <a href="?lang=en">en</a>
    |
    <a href="?lang=de">ru</a>
    </span>

    <script type="text/javascript">

        $(document).ready(function () {
            newComment();
        });

    </script>

</head>
<body>

<table class="users">
    <thead>
    <tr>
        <th><spring:message code="label.title"/></th>
        <th><spring:message code="label.text"/></th>
        <th><spring:message code="label.rating"/></th>
        <th><spring:message code="label.username"/></th>
    </tr>
    </thead>
    <tbody id="comments">
    <c:forEach items="${comments}" var="comment">
        <tr>
            <td>${comment.title}</td>
            <td>${comment.text}</td>
            <td>${comment.rating}</td>
            <td>${comment.user.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<form>
    Title:<br>
    <input type="text" name="newTitle" id="newTitle"><br>
    Text:<br>
    <input type="text" name="newText" id="newText">
</form>
<input type="button" value=
<spring:message code="label.newComment"/> id="newComment"/>

</body>
</html>