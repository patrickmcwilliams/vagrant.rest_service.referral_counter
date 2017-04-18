
<!doctype html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Hello AngularJS</title>
<link href="css/angular-bootstrap.css" rel="stylesheet">
<style type="text/css">
[ng\:cloak], [ng-cloak], .ng-cloak {
  display: none !important;
}
</style>
</head>

<body ng-app="hello">
  <div class="container">
    <h1>Greeting</h1>
    <div ng-controller="home" ng-cloak class="ng-cloak">
      <p>The ID is {{greeting.id}}</p>
      <p>The content is {{greeting.content}}</p>
    </div>
  </div>
  <script src="js/angular-bootstrap.js" type="text/javascript"></script>
  <script src="js/hello.js"></script>
</body>
</html>