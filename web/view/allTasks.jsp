<%--
  Created by IntelliJ IDEA.
  User: acube
  Date: 16.05.2016
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en" class="no-js">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">
  <meta name="theme-color" content="#3e454c">

  <title>All tasks</title>

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

    function isValidDate(date) {
      var matches = /^(\d{2})[-\/](\d{2})[-\/](\d{4})$/.exec(date);
      if (matches == null) return false;
      var d = matches[2];
      var m = matches[1] - 1;
      var y = matches[3];
      var composedDate = new Date(y, m, d);
      return composedDate.getDate() == d &&
              composedDate.getMonth() == m &&
              composedDate.getFullYear() == y;
    }

    function validateForm() {
      var name = document.forms["formEditTask"]["name"].value;
      var priority = document.forms["formEditTask"]["prioritising"].value;
      var done = document.forms["formEditTask"]["isDone"].value;
      var type = document.forms["formEditTask"]["taskType"].value;
      var start = document.forms["formEditTask"]["dateCreate"].value;
      var end = document.forms["formEditTask"]["dateDeadLine"].value;
      var body = document.forms["formEditTask"]["body"].value;

      var isValidStart = isValidDate(start);
      var isValidEnd = isValidDate(end);

      if (name == null || name == ""
          || priority == null || priority == ""
          || type == null || type == ""
          || body == null || body == "") {
        alert("Name must be filled out");
        return false;
      }
    }
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

          <h2 class="page-title">All tasks</h2>

          <div class="panel panel-primary">
            <div class="panel-heading">Contextual tables</div>
            <div class="panel-body">

              <c:if test="${success == true}">
                <div class="alert alert-dismissible alert-success">
                  <button type="button" class="close" data-dismiss="alert"><i class="fa fa-remove"></i></button>
                  <strong>Well done!</strong> You update all tasks
                </div>
              </c:if>

              <c:if test="${success == false}">
                <div class="alert alert-dismissible alert-danger">
                  <button type="button" class="close" data-dismiss="alert"><i class="fa fa-remove"></i></button>
                  <strong>Oh wrong!</strong> Something go wrong! Try again later
                </div>
              </c:if>

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
                  <c:if test="${isEdit == true}">
                    <th>Action</th>
                  </c:if>
                </tr>
                </thead>
                <tbody>

                <!--1 Home 2 Work 3 My = TASKS-->
                <c:forEach var="i" items="${tasks}" varStatus="stat">

                  <form:form name="formEditTask" method="post" onsubmit="return validateForm()" action="${i.id}/actionTask" class="form-horizontal">
                    <!--Якщо ми використовуємо modelAttribute="taskModel" то всі поля повинні мати імена як в обєктні ймоделі.
                    Інакше, просто нічого не буде відбуватись, тому що не буде як такого біндінгу-->

                    <c:if test="${i.taskType.id == 1}">
                      <tr class="info">
                    </c:if>

                    <c:if test="${i.taskType.id == 2}">
                      <tr class="success">
                    </c:if>

                    <c:if test="${i.taskType.id == 3}">
                      <tr class="warning">
                    </c:if>


                    <c:if test="${isEdit == false}">
                      <td>${i.id}</td>
                      <td>${i.name}</td>
                      <td>${i.prioritising}</td>
                      <td><input type="checkbox" <c:if test="${i.done == true}">checked</c:if>/></td>
                      <td>${i.taskType.name}</td>
                      <td>${i.dateCreate}</td>
                      <td>${i.dateDeadLine}</td>
                      <td>${i.body}</td>
                    </c:if>

                    <c:if test="${isEdit == true}">
                      <td>${i.id}</td>
                      <td><input type="text" name="name" value="${i.name}"/></td>
                      <td><input type="text" name="prioritising" value="${i.prioritising}"/></td>
                      <td><input type="checkbox" name="isDone" id="check${i.id}" <c:if test="${i.done == true}">checked</c:if>/></td>
                      <td><input type="text" name="taskType" value="${i.taskType.name}"/></td>
                      <td>
                        <input type="text" name="dateCreate" value="${i.dateCreate}" style="height: 0px; margin-bottom: 0px;" id="datetimepickerStart${i.id}"
                               class="form-control mb">
                      </td>
                      <td>
                        <input type="text" name="dateDeadLine" value="${i.dateDeadLine}" style="height: 0px; margin-bottom: 0px" id="datetimepickerEnd${i.id}"
                               class="form-control mb">
                      </td>
                      <td><input type="text" name="body" value="${i.body}"/></td>
                    </c:if>

                    <script>
                      $(function() {
                        $("#datetimepickerStart${i.id}, #datetimepickerEnd${i.id}").datepicker();
                      });
                    </script>

                    <c:if test="${isEdit == true}">
                      <td>
                        <input class="btn btn-primary" style="padding: 2px 10px; line-height: 17px; font-size: 14px;"
                               type="submit" name="updateTaskAction" value="update"/>
                        <input class="btn btn-default" style="padding: 2px 10px; line-height: 17px; font-size: 14px;"
                               type="submit" name="deleteTaskAction" value="delete"/>
                      </td>
                    </c:if>

                    </tr>
                  </form:form>
                </c:forEach>
                </tbody>

              </table>

              <c:if test="${isEdit == false}">
                <form:form method="get" action="allEditable">
                  <div class="form-group">
                    <div class="col-sm-2">
                      <button class="btn btn-default" type="submit">Edit mode</button>
                    </div>
                  </div>
                </form:form>
              </c:if>

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

</body>

</html>