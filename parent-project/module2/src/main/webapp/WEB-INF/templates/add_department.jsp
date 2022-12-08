<jsp:include page="_header.jsp"/>
<h1>Add new department</h1>

<form method="post" action="/hello/add-department.html">
  <div class="mb-3">
    <label for="departmentName" class="form-label">Name</label>
    <input type="text" name="departmentName" class="form-control" id="departmentName" aria-describedby="nameHelp">
    <div id="nameHelp" class="form-text">Enter department name</div>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="_footer.jsp"/>