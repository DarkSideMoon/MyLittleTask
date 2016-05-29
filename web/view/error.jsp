<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: acube
  Date: 19.05.2016
  Time: 1:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en" class="no-js">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">
  <meta name="theme-color" content="#3e454c">

  <title>Error</title>

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


<div class="ts-main-content">
  <div class="content-wrapper">
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-6">

          <h1 class="page-title">Error</h1>

          <div class="well">
            <h3><code name="errorIn" id="errorIn">${errorIn}</code></h3>
            <h3 class="text-primary">Stack trace</h3>
            <h3><p class="text-danger" name="stackTrace" id="stackTrace">${stackTrace}</p></h3>

            <a href="<c:url value="/account/logout" />">Logout</a>
          </div>

        </div>
      </div>

      <div class="row">
        <div class="clearfix pt pb">
          <div class="col-md-12">
            <em>Thank you for using Task Service</em>
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
