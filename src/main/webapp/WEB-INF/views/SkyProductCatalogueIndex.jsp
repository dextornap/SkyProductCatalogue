<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>Sky Product Catalogue</title>  
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/static/css/catalogue_app.css' />" rel="stylesheet"></link>
  </head>
  
  <body ng-app="skyProductCatalogueApp" class="ng-cloak">
  
  	  <div ng-view></div>
      
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-route.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-cookies.js"></script>
      <script src="<c:url value='/static/js/catalogue_app.js' />"></script>
      <script src="<c:url value='/static/js/service/catalogue_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/catalogue_controller.js' />"></script>
      <script src="<c:url value='/static/js/controller/subscription_controller.js' />"></script>
  </body>
</html>