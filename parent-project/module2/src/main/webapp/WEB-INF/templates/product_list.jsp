<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Products:</h1>

<table style="width:100%">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Price</th>
  </tr>
  <c:forEach items="${products}" var="product">
  <tr>
    <td><c:out value="${product.id}"/></td>
    <td><c:out value="${product.name}"/></td>
    <td><c:out value="${product.price}"/></td>
  </tr>
  </c:forEach>
</table>

<jsp:include page="_footer.jsp"/>