<%--
  Created by IntelliJ IDEA.
  User: acube
  Date: 27.03.2016
  Time: 0:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Sign in</title>

  <!-- Font awesome -->
  <link rel="stylesheet" href="../resources/css/font-awesome.min.css">
  <!-- Sandstone Bootstrap CSS -->
  <link rel="stylesheet" href="../resources/css/bootstrap1.min.css">
  <!-- Bootstrap Datatables -->
  <link rel="stylesheet" href="../resources/css/dataTables.bootstrap.min.css">
  <!-- Bootstrap social button library -->
  <link rel="stylesheet" href="../resources/css/bootstrap-social.css">
  <!-- Bootstrap select -->
  <link rel="stylesheet" href="../resources/css/bootstrap-select.css">
  <!-- Bootstrap file input -->
  <link rel="stylesheet" href="../resources/css/fileinput.min.css">
  <!-- Awesome Bootstrap checkbox -->
  <link rel="stylesheet" href="../resources/css/awesome-bootstrap-checkbox.css">
  <!-- Admin Stye -->
  <link rel="stylesheet" href="../resources/css/style1.css">

</head>

<body style="background: #E9F0F7;">

<div class="login-page bk-img" style="background-image: url(../resources/img/login-bg.jpg);">
  <div class="form-content">
    <div class="container">
      <div class="row">
        <div class="col-md-6 col-md-offset-3">
          <h1 class="text-center text-bold text-light mt-4x">Sign up</h1>
          <div class="well row pt-2x pb-3x bk-light">
            <div class="col-md-8 col-md-offset-2">
              <form action="" class="mt">

                <label class="text-uppercase text-sm">Username</label>
                <input type="text" placeholder="Username" class="form-control mb">

                <label class="text-uppercase text-sm">Email</label>
                <input type="email" placeholder="Email" class="form-control mb">

                <label class="text-uppercase text-sm">Password</label>
                <input type="password" placeholder="Password" class="form-control mb">

                <button class="btn btn-primary btn-block" type="submit">Sign up</button>

              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<script>
  !function ($) {
    $(document).on("click","ul.nav li.parent > a > span.icon", function(){
      $(this).find('em:first').toggleClass("glyphicon-minus");
    });
    $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
  }(window.jQuery);

  $(window).on('resize', function () {
    if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
  })
  $(window).on('resize', function () {
    if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
  })
</script>
</body>

</html>

