<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${errors != null}">
    <c:forEach var="error" items="${errors}">
        <p style="color: red">*${error} <br></p>
    </c:forEach>
</c:if>
