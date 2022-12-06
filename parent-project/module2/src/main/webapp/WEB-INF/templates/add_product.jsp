<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
  <body>

<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/hello/index.html">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/hello/products.html">Products</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Select action
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/hello/add-product.html">Add a product</a></li>
            <li><a class="dropdown-item" href="/hello/add-department.html">Add department</a></li>
            <li><a class="dropdown-item" href="/hello/add-empployee.html">Add employee</a></li>
            <li><a class="dropdown-item" href="/hello/add-meeting.html">Add meeting</a></li>
          </ul>
        </li>
      </ul>
      <form class="d-flex" role="search" action="/hello/search.do" method="post">
        <input class="form-control me-2" type="search" name="pname" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>

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


    <a>index.jsp</a>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
  </body>
</html>
