<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: acube
  Date: 16.05.2016
  Time: 23:44
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

  <title>Work tasks</title>

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
  <a href="<c:url value="/dashboard" />" class="logo"><img src="../resources/img/logo.jpg" class="img-responsive" alt=""></a>
  <span class="menu-btn"><i class="fa fa-bars"></i></span>
  <ul class="ts-profile-nav">
    <li class="ts-account">
      <a href="#"><img src="../resources/img/user.png" class="ts-avatar hidden-side" alt=""> Account <i class="fa fa-angle-down hidden-side"></i></a>
      <ul>
        <li><a href="<c:url value="/account/my" />">My Account</a></li>
      </ul>
    </li>
  </ul>
</div>

<div class="ts-main-content">
  <nav class="ts-sidebar">
    <ul class="ts-sidebar-menu">
      <li class="ts-label">Main</li>
      <li class="open"><a href="<c:url value="/main/board" />"><i class="fa fa-dashboard"></i> Dashboard</a></li>
      <li><a href="#"><i class="fa fa-desktop"></i>My Tasks</a>
        <ul>
          <li><a href="<c:url value="/task/addPage" />"> Add task</a></li>
          <li><a href="<c:url value="/task/all" />"> All</a></li>
          <li><a href="<c:url value="/task/home" />"> Home</a></li>
          <li><a href="<c:url value="/task/work" />"> Work</a></li>
          <li><a href="<c:url value="/task/my" />"> My</a></li>
          <!--<li><a href="otherTasks.jsp">
          Others</a></li>-->
        </ul>
      </li>
      <!--<li><a href="charts.jsp"><i class="fa fa-pie-chart"></i> Charts</a></li>
      <li><a href="charts.jsp"><i class="fa fa-pie-chart"></i> SigmaJS Cahrts</a></li> <!-- Charts with the splitting tasks-->
      <li><a href="<c:url value="/web/google" />"><i class="fa fa-google"></i> Web</a></li>
      <li><a href="notes.jsp"><i class="fa fa-sticky-note-o"></i> My notes</a></li>
      <li><a href="<c:url value="/info/about" />"><i class="fa fa-github"></i> About</a></li>

    </ul>

    <div>
      <blockquote>
        <p style="color: white;" id="userInSystem" name="userInSystem">${userInSystem}</p>
      </blockquote>
    </div>
  </nav>
  <div class="content-wrapper">
    <div class="container-fluid">

      <div class="row">
        <div class="col-md-12">

          <h2 class="page-title">Work tasks</h2>

          <div class="panel panel-primary">
            <div class="panel-heading">Contextual tables</div>
            <div class="panel-body">
              <table class="table table-striped table-hover ">
                <thead>
                <tr>
                  <th>#</th>
                  <th>Name</th>
                  <th>Priority</th>
                  <th>IsDone</th>
                  <th>Type</th>
                  <th>Start</th>
                  <th>Deadline</th>
                  <th>Text</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="i" items="${workTasksList}" varStatus="stat">

                  <tr class="warning">
                    <td>${i.id}</td>
                    <td>${i.name}</td>
                    <td>${i.prioritising}</td>
                    <td>${i.done}</td>
                    <td>${i.taskType.name}</td>
                    <td>${i.dateCreate}</td>
                    <td>${i.dateDeadLine}</td>
                    <td>${i.body}</td>
                  </tr>
                </c:forEach>
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