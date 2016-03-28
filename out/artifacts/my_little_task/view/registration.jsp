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
  <title>Forms</title>

  <link href="resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="resources/css/datepicker3.css" rel="stylesheet">
  <link href="resources/css/styles.css" rel="stylesheet">

  <!--[if lt IE 9]>
  <script src="resources/js/html5shiv.min.js"></script>
  <script src="resources/js/respond.min.js"></script>
  <![endif]-->

</head>

<body style="width: 1900px;">

<div class="row">
  <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
    <div class="login-panel panel panel-default">
      <div class="panel-heading">Registration</div>
      <div class="panel-body">
        <form role="form">
          <fieldset>
            <div class="form-group">
              <input class="form-control" placeholder="First name" name="firtsName" type="text" autofocus="">
            </div>
            <div class="form-group">
              <input class="form-control" placeholder="Last name" name="lastName" type="text" autofocus="">
            </div>
            <div class="form-group">
              <input class="form-control" placeholder="E-mail" name="email" type="email" autofocus="">
            </div>
            <div class="form-group">
              <input class="form-control" placeholder="Password" name="password" type="password" value="">
            </div>
            <a href="../index.jsp" class="btn btn-primary">Registration</a>
          </fieldset>
        </form>
      </div>
    </div>
  </div><!-- /.col-->
</div><!-- /.row -->

<script src="resources/js/jquery-1.11.1.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/chart.min.js"></script>
<script src="resources/js/chart-data.js"></script>
<script src="resources/js/easypiechart.js"></script>
<script src="resources/js/easypiechart-data.js"></script>
<script src="resources/js/bootstrap-datepicker.js"></script>
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