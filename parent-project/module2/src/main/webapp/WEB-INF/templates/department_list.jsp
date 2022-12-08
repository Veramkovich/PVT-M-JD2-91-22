<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Departments</h1>

<table style="width:100%" class="table">
  <tr>
    <th>Name</th>
  </tr>
  <c:forEach items="${departments}" var="department">
  <tr>
    <td><c:out value="${department}"/></td>
  </tr>
  </c:forEach>
</table>

<jsp:include page="_footer.jsp"/>