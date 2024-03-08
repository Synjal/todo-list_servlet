<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${taskList != null}">
    <div class="section">
        <h1>Liste des taches</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Etat</th>
                <th>Responsable</th>
            </tr>
            <c:forEach var="task" items="${taskList}" varStatus="loop">
                <c:choose>
                    <c:when test="${task.getStatus() == 'TODO'}">
                        <tr class="todo">
                    </c:when>
                    <c:when test="${task.getStatus() == 'DONE'}">
                        <tr class="done">
                    </c:when>
                    <c:otherwise>
                        <tr class="progress">
                    </c:otherwise>
                </c:choose>
                    <td>${task.getId() + 1}</td>
                    <td>${task.getName()}</td>
                    <td>${task.getStatus()}</td>
                    <td>${task.getUser()}</td>
                    <td class="buttons">
                        <a href="todo?task-start_id=${loop.index}">
                            <img src="${pageContext.request.contextPath}/assets/move-to-next.png"
                                 alt="start"
                                 height="25px"
                                 width="25px"/></a>
                        <a href="todo?task-done_id=${loop.index}">
                            <img src="${pageContext.request.contextPath}/assets/check-mark.png"
                                 alt="validate"
                                 height="25px"
                                 width="25px"/></a>
                        <a href="todo?task-delete_id=${loop.index}">
                            <img src="${pageContext.request.contextPath}/assets/delete.png"
                                 alt="delete"
                                 height="25px"
                                 width="25px"/></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>

