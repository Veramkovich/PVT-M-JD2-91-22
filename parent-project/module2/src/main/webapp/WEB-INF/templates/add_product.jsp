<jsp:include page="_header.jsp"/>
<h1>Add product</h1>

<form method="post" action="/hello/add-product.html">
  <div class="mb-3">
    <label for="name1" class="form-label">Name</label>
    <input type="text" name="name" class="form-control" id="name1" aria-describedby="nameHelp">
    <div id="nameHelp" class="form-text">Enter product name</div>
  </div>
  <div class="mb-3">
    <label for="price1" class="form-label">Price</label>
    <input type="number" name="price" class="form-control" id="price1">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="_footer.jsp"/>
