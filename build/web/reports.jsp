<%-- 
    Document   : welcome
    Created on : 28-Feb-2015, 21:24:16
    Author     : mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/ico" href="img/favicon.ico">
        <title>Welcome to NABTA</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- JQuery (necessary for Bootstrap's JavaScript plugins) -->
        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>-->
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <ul class="nav nav-pills">
            <li role="presentation"><a href="index.jsp">Home</a></li>
            <li role="presentation"><a href="agreement.jsp">Register Vehicle</a></li>
            <li role="presentation"><a href="viewDetails.jsp">View Registered Vehicle</a></li>
            <li role="presentation" class="active"><a href="#">Reports</a></li>
        </ul>
        <h4>Click on a report to view it.</h4>
        <form action="ViewTaxis" method="POST">
            <button type="submit" class="btn btn-primary">View All Taxis</button>
        </form>
        <form action="ViewMinibuses" method="POST">
            <button type="submit" class="btn btn-primary">View All Minibuses</button>
        </form>
        <form action="ViewBuses" method="POST">
            <button type="submit" class="btn btn-primary">View All Buses</button>
        </form>
        <form action="Registered" method="POST">
            <button type="submit" class="btn btn-primary">View All Registered</button>
        </form>
        <form action="Unregistered" method="POST">
            <button type="submit" class="btn btn-primary">View All Unregistered</button>
        </form>
        <form action="Owners" method="POST">
            <button type="submit" class="btn btn-primary">View All Owners</button>
        </form>
        <form action="Drivers" method="POST">
            <button type="submit" class="btn btn-primary">View All Drivers</button>
        </form>
        <form action="Accidents" method="POST">
            <button type="submit" class="btn btn-primary">View All Accidents</button>
        </form>
    </body>
</html>
