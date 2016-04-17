<%--
  Created by IntelliJ IDEA.
  User: acube
  Date: 17.04.2016
  Time: 23:38
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

  <title>Charts</title>

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

          <h2 class="page-title">Charts</h2>
          <div class="row">
            <div class="col-md-7">
              <div class="panel panel-default">
                <div class="panel-heading">Line Chart</div>
                <div class="panel-body">
                  <div class="chart">
                    <canvas id="lineChart" height="310" width="600"></canvas>
                  </div>
                  <div id="legendDiv"></div>
                </div>
              </div>
            </div>
            <div class="col-md-5">
              <div class="panel panel-default">
                <div class="panel-heading">Radar Chart</div>
                <div class="panel-body">
                  <div class="row">
                    <div class="col-md-12">
                      <div class="chart chart-doughnut">
                        <canvas id="chart-area" width="500" height="280" />
                      </div>
                    </div>

                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="row">
            <div class="col-md-4">
              <div class="panel panel-default">
                <div class="panel-heading">Polar Chart</div>
                <div class="panel-body">
                  <div class="chart chart-doughnut">
                    <canvas id="chart-area2" width="1200" height="600" />
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-8">
              <div class="panel panel-default">
                <div class="panel-heading">Bar Chart</div>
                <div class="panel-body">
                  <div class="chart">
                    <canvas id="chart-bar" height="400" width="1200"></canvas>
                  </div>

                </div>
              </div>
            </div>
          </div>

          <div class="row">
            <div class="col-md-6">
              <div class="panel panel-default">
                <div class="panel-heading">Pie Chart</div>
                <div class="panel-body">
                  <div class="row">
                    <div class="col-md-4">
                      <ul class="chart-dot-list">
                        <li class="a1">date 1</li>
                        <li class="a2">data 2</li>
                        <li class="a3">data 3</li>
                      </ul>
                    </div>
                    <div class="col-md-8">
                      <div class="chart chart-doughnut">
                        <canvas id="chart-area3" width="1200" height="900" />
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-6">
              <div class="panel panel-default">
                <div class="panel-heading">Doughnut</div>
                <div class="panel-body">
                  <div class="row">
                    <div class="col-md-4">
                      <ul class="chart-dot-list">
                        <li class="a1">date 1</li>
                        <li class="a2">data 2</li>
                        <li class="a3">data 3</li>
                      </ul>
                    </div>
                    <div class="col-md-8">
                      <div class="chart chart-doughnut">
                        <canvas id="chart-area4" width="1200" height="900" />
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

        </div>
      </div>

      <div class="row">
        <div class="clearfix pt pb">
          <div class="col-md-12">
            <em>Thank you for using <a href="http://themestruck.com/theme/harmony/"> Harmony Admin Theme </a> by <a href="http://themestruck.com/">ThemeStruck</a></em>
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

<script>

  window.onload = function(){

    // Line chart from swirlData
    var ctx = document.getElementById("lineChart").getContext("2d");
    window.myLine = new Chart(ctx).Line(swirlData, {
      responsive: true,
      scaleShowVerticalLines: false,
      scaleBeginAtZero : true,
    });

    // Radar Chart from radarData
    var doctx = document.getElementById("chart-area").getContext("2d");
    window.myDoughnut = new Chart(doctx).Radar(radarData, {responsive : true});

    // PolarArea from polarData
    var doctx = document.getElementById("chart-area2").getContext("2d");
    window.myDoughnut = new Chart(doctx).PolarArea(polarData, {responsive : true});

    // Pie Chart from doughutData
    var doctx = document.getElementById("chart-area3").getContext("2d");
    window.myDoughnut = new Chart(doctx).Pie(doughnutData, {responsive : true});

    // Dougnut Chart from doughnutData
    var doctx = document.getElementById("chart-area4").getContext("2d");
    window.myDoughnut = new Chart(doctx).Doughnut(doughnutData, {responsive : true});

    // Bar Chart from barChartData
    var ctx = document.getElementById("chart-bar").getContext("2d");
    window.myBar = new Chart(ctx).Bar(barChartData, {
      responsive : true
    });


  }


</script>

</body>

</html>