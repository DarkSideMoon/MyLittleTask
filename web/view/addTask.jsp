<%--
  Created by IntelliJ IDEA.
  User: acube
  Date: 30.05.2016
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en" class="no-js">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">
  <meta name="theme-color" content="#3e454c">

  <title>Main board</title>

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

  <!--Date time picker-->
  <link rel="stylesheet" href="../resources/css/jquery-ui.min.css">
  <script src="../resources/js/jquery.min.js"></script>
  <script src="../resources/js/jquery-1.11.1.min.js"></script>
  <script src="../resources/js/jquery-ui.min.js"></script>

  <script>
    $(function() {
      $("#datetimepickerStart, #datetimepickerEnd").datepicker();
    });


  </script>

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
        <p style="color: white;">User in system</p>
      </blockquote>
    </div>
  </nav>

  <div class="content-wrapper">
    <div class="container-fluid">

      <div class="row">
        <div class="col-md-12">

          <h2 class="page-title">Forms</h2>

          <div class="panel panel-default">
            <div class="panel-heading">More input forms</div>
            <div class="panel-body">

              <form method="post" action="addnew" class="form-horizontal">

                <c:if test="${success == false}">
                  <div class="alert alert-dismissible alert-danger">
                    <button type="button" class="close" data-dismiss="alert"><i class="fa fa-remove"></i></button>
                    <strong>Oh wrong!</strong> Something go bad! Try again later
                  </div>
                </c:if>

                <c:if test="${success == true}">
                  <div class="alert alert-dismissible alert-success">
                    <button type="button" class="close" data-dismiss="alert"><i class="fa fa-remove"></i></button>
                    <strong>Well done!</strong> You create new task!
                  </div>
                </c:if>

                <div class="form-group">
                  <label class="col-sm-2 control-label">Name</label>
                  <div class="col-sm-10">
                    <input type="text" placeholder="Name of task" name="name" class="form-control mb">
                  </div>
                </div>

                <div class="hr-dashed"></div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">Priority</label>
                  <div class="col-sm-10">
                    <div class="row">
                      <div class="col-xs-4">
                        <input type="number" min="1" max="5" name="priority" class="form-control" placeholder="Priority">
                      </div>
                    </div>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">Type</label>
                  <div class="col-sm-10">
                    <div class="row">
                      <div class="col-sm-10">
                        <select class="selectpicker" name="type" multiple data-selected-text-format="count">
                          <option>Home</option>
                          <option>Work</option>
                          <option>My</option>
                        </select>
                      </div>
                    </div>
                  </div>
                </div>

                <div class="hr-dashed"></div>
                <div class="form-group">
                  <label class="col-sm-2 control-label">Body</label>
                  <div class="col-sm-10">
                    <textarea class="form-control" name="body" rows="3"></textarea>
                  </div>
                </div>
                <div class="hr-dashed"></div>

                <div class="form-group">
                  <label class="col-sm-2 control-label">Date start</label>
                  <div class="col-sm-10">
                    <input type="text" name="dateStart" id="datetimepickerStart" placeholder="Name of task"
                           class="form-control mb">


                  </div>
                </div>


                <div class="form-group">
                  <label class="col-sm-2 control-label">Date end</label>
                  <div class="col-sm-10">
                    <input type="text" name="dateEnd" id="datetimepickerEnd"
                           class="form-control mb">
                  </div>
                </div>

                <div class="hr-dashed"></div>
                <div class="form-group">
                  <label class="col-sm-2 control-label"></label>
                  <div class="col-sm-10">
                    <button class="btn btn-primary col-sm-1" type="submit">ADD</button>
                  </div>
                </div>
            </form>

          </div>
        </div>

      </div>
    </div>

    </div>
  </div>
</div>




<!-- Loading Scripts -->
<script src="../resources/js/bootstrap-select.min.js"></script>
<script src="../resources/js/bootstrap.min.js"></script>
<script src="../resources/js/jquery.dataTables.min.js"></script>
<script src="../resources/js/dataTables.bootstrap.min.js"></script>
<script src="../resources/js/Chart.min.js"></script>
<script src="../resources/js/fileinput.js"></script>
<script src="../resources/js/chartData.js"></script>
<script src="../resources/js/main.js"></script>

<script>

  window.onload = function(){

    // Line chart from swirlData for dashReport
    //var ctx = document.getElementById("dashReport").getContext("2d");
    /*
     window.myLine = new Chart(ctx).Line(swirlData, {
     responsive: true,
     scaleShowVerticalLines: false,
     scaleBeginAtZero : true,
     multiTooltipTemplate: ,
     });
     */
    // Pie Chart from doughutData
    var doctx = document.getElementById("chart-area3").getContext("2d");
    window.myDoughnut = new Chart(doctx).Pie(doughnutData, {responsive : true});

    // Dougnut Chart from doughnutData
    var doctx = document.getElementById("chart-area4").getContext("2d");
    window.myDoughnut = new Chart(doctx).Doughnut(doughnutData, {responsive : true});

  }
</script>

</body>

</html>