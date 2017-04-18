
<!doctype html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></script>

<title>Web Referral Analytics R US</title>
<link href="css/angular-bootstrap.css" rel="stylesheet">
<style type="text/css">
[ng\:cloak], [ng-cloak], .ng-cloak {
  display: none !important;
}
</style>
</head>

<body ng-app="app">
  <div class="container">
    <h1>Top 3 Web Referrers</h1>
    <div ng-controller="main" ng-cloak class="ng-cloak">
      <table>
      	<tr>
      		<td>
	      		<p>The top Domain is {{referrerOne.url}}</p>
	      		<p>With {{referrerOne.total}} hits</p>
      		</td>
      		<td>
	      		<p>Number two is {{referrerTwo.url}}</p>
	      		<p>With {{referrerTwo.total}} hits</p>
      		</td>
      		<td>
	      		<p>Last place at number three {{referrerThree.url}}</p>
	      		<p>With {{referrerThree.total}} hits</p>
      		</td>
      	</tr>
      </table>
    </div>
  </div>
  <script src="js/app.js"></script>
</body>
</html>