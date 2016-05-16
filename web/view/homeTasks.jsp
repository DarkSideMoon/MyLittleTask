<%--
  Created by IntelliJ IDEA.
  User: acube
  Date: 16.05.2016
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="no-js">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">
  <meta name="theme-color" content="#3e454c">

  <title>Home tasks</title>

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

<body>
<div class="brand clearfix">
  <a href="dashboard.jsp" class="logo"><img src="../resources/img/logo.jpg" class="img-responsive" alt=""></a>
  <span class="menu-btn"><i class="fa fa-bars"></i></span>
  <ul class="ts-profile-nav">
    <li><a href="#">Help</a></li>
    <li><a href="#">Settings</a></li>
    <li class="ts-account">
      <a href="#"><img src="../resources/img/ts-avatar.jpg" class="ts-avatar hidden-side" alt=""> Account <i class="fa fa-angle-down hidden-side"></i></a>
      <ul>
        <li><a href="#">My Account</a></li>
        <li><a href="signout.jsp">Logout</a></li>
      </ul>
    </li>
  </ul>
</div>

<div class="ts-main-content">
  <nav class="ts-sidebar">
    <ul class="ts-sidebar-menu">
      <li class="ts-label">Main</li>
      <li class="open"><a href="dashboard.jsp"><i class="fa fa-dashboard"></i> Dashboard</a></li>
      <li><a href="#"><i class="fa fa-desktop"></i>My Tasks</a>
        <ul>
          <li><a href="blank.jsp"> All</a></li>
          <li><a href="blank.jsp"> Home</a></li>
          <li><a href="blank.jsp"> Work</a></li>
          <li><a href="blank.jsp"> My</a></li>
          <li><a href="blank.jsp"> Others</a></li>
        </ul>
      </li>
      <li><a href="charts.jsp"><i class="fa fa-pie-chart"></i> Charts</a></li>
      <li><a href="charts.jsp"><i class="fa fa-pie-chart"></i> SigmaJS Cahrts</a></li> <!-- Charts with the splitting tasks-->
      <li><a href="blank.jsp"><i class="fa fa-google"></i> Web</a></li>
      <li><a href="notes.jsp"><i class="fa fa-sticky-note-o"></i> My notes</a></li>

      <!-- Account from above -->
      <ul class="ts-profile-nav">
        <li><a href="#">Help</a></li>
        <li><a href="#">Settings</a></li>
        <li class="ts-account">
          <a href="#"><img src="img/ts-avatar.jpg" class="ts-avatar hidden-side" alt=""> Account <i class="fa fa-angle-down hidden-side"></i></a>
          <ul>
            <li><a href="blank.jsp">My Account</a></li>
            <li><a href="#">Logout</a></li>
          </ul>
        </li>
      </ul>
    </ul>

    <div>
      <blockquote>
        <p style="color: white;">User in system</p>
      </blockquote>
    </div>
  </nav>
  <div class="content-wrapper">
    <div class="container-fluid">

      <div class="row">
        <div class="col-md-12">

          <h2 class="page-title">All tasks</h2>

          <div class="panel panel-success">
            <div class="panel-heading">Contextual tables</div>
            <div class="panel-body">
              <table class="table table-striped table-hover ">
                <thead>
                <tr>
                  <th>#</th>
                  <th>Column heading</th>
                  <th>Column heading</th>
                  <th>Column heading</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                  <td>1</td>
                  <td>Column content</td>
                  <td>Column content</td>
                  <td>Column content</td>
                </tr>
                <tr>
                  <td>2</td>
                  <td>Column content</td>
                  <td>Column content</td>
                  <td>Column content</td>
                </tr>
                <tr class="info">
                  <td>3</td>
                  <td>Column content</td>
                  <td>Column content</td>
                  <td>Column content</td>
                </tr>
                <tr class="success">
                  <td>4</td>
                  <td>Column content</td>
                  <td>Column content</td>
                  <td>Column content</td>
                </tr>
                <tr class="danger">
                  <td>5</td>
                  <td>Column content</td>
                  <td>Column content</td>
                  <td>Column content</td>
                </tr>
                <tr class="warning">
                  <td>6</td>
                  <td>Column content</td>
                  <td>Column content</td>
                  <td>Column content</td>
                </tr>
                <tr class="active">
                  <td>7</td>
                  <td>Column content</td>
                  <td>Column content</td>
                  <td>Column content</td>
                </tr>
                </tbody>
              </table>
            </div>
          </div>

        </div>
      </div>
    </div>
  </div>
</div>

<!-- Loading Scripts -->
<script src="../resources/js/jquery.min.js"></script>
<script src="../resources/js/bootstrap-select.min.js"></script>
<script src="../resources/js/bootstrap.min.js"></script>
<script src="../resources/js/jquery.dataTables.min.js"></script>
<script src="../resources/js/dataTables.bootstrap.min.js"></script>
<script src="../resources/js/Chart.min.js"></script>
<script src="../resources/js/fileinput.js"></script>
<script src="../resources/js/chartData.js"></script>
<script src="../resources/js/main.js"></script>

</body>

</html>