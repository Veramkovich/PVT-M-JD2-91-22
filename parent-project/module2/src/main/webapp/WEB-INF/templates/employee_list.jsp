<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Employees</h1>

<table style="width:100%" class="table">
  <tr>
    <th>Name</th>
    <th>Address</th>
    <th>Department</th>
    <th>Photo</th>
  </tr>
  <c:forEach items="${employees}" var="employee">
  <tr>
    <td><c:out value="${employee.firstName} ${employee.lastName}"/></td>
    <td><c:out value="${employee.employeeDetail.city} ${employee.employeeDetail.street}"/></td>
    <td><c:out value="${employee.department.departmentName}"/></td>
    <td><image src="/hello/image/${employee.id}/photo.jpg" class="img-thumbnail"><td>
  </tr>
  </c:forEach>
</table>

<jsp:include page="_footer.jsp"/>