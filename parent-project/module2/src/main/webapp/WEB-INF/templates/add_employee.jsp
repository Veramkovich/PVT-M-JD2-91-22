<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Add employee</h1>

<form method="post" action="/hello/add-employee.html" enctype="multipart/form-data">
  <div class="mb-3">
      <label for="photo" class="form-label">Photo</label>
      <input type="file" name="photo" class="form-control" id="photo">
  </div>
  <!-- firstName -->
  <div class="mb-3">
    <label for="firstName" class="form-label">First Name</label>
    <input type="text" name="firstName" class="form-control" id="firstName" aria-describedby="nameHelp">
    <div id="nameHelp" class="form-text">Enter first name</div>
  </div>
  <!-- lastName -->
  <div class="mb-3">
      <label for="lastName" class="form-label">Last Name</label>
      <input type="text" name="lastName" class="form-control" id="lastName" aria-describedby="nameHelp">
      <div id="nameHelp" class="form-text">Enter last name</div>
  </div>
   <!-- birthDate -->
    <div class="mb-3">
     <label for="birthDate" class="form-label">Birth Date</label>
     <input type="text" name="birthDate" class="form-control" id="birthDate" aria-describedby="nameHelp">
     <div id="nameHelp" class="form-text">Enter birthdate name</div>
    </div>
  <!-- employeeDetail.city -->
    <div class="mb-3">
     <label for="employeeDetail.city" class="form-label">City</label>
     <input type="text" name="employeeDetail.city" class="form-control" id="employeeDetail.city" aria-describedby="nameHelp">
     <div id="nameHelp" class="form-text">Enter city name</div>
    </div>
  <!-- employeeDetail.street -->
   <div class="mb-3">
       <label for="employeeDetail.street" class="form-label">Street</label>
       <input type="text" name="employeeDetail.street" class="form-control" id="employeeDetail.street" aria-describedby="nameHelp">
       <div id="nameHelp" class="form-text">Enter street address</div>
   </div>

   <div class="mb-3">
   <label for="department.id">Choose a department:</label>
   <select class="form-select" id="department.id" name="department.id">
     <c:forEach items="${departments}" var="department">
     <option value="${department.id}">${department.departmentName}</option>
     </c:forEach>
   </select>
   </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
<jsp:include page="_footer.jsp"/>

