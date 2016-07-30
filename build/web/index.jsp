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
        <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> -->
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@page import= "java.util.Date"%>
        <% Date date = new Date();
            String msg = "";
            if (date.getHours() > 0 && date.getHours() < 12) {
                msg = "Good Morning!";
            } else if (date.getHours() >= 12 && date.getHours() < 18) {
                msg = "Good Afternoon!";
            } else if (date.getHours() >= 18) {
                msg = "Good Evening!";
            }%>
            
        <ul class="nav nav-pills">
            <li role="presentation" class="active"><a href="#">Home</a></li>
            <li role="presentation"><a href="agreement.jsp">Register Vehicle</a></li>
            <li role="presentation"><a href="viewDetails.jsp">View Registered Vehicle</a></li>
            <li role="presentation"><a href="reports.jsp">Reports</a></li>
        </ul>
        <h3><%= msg%> Welcome to the NABTA. </h3>
        
        <div class="well">
            <p>This site allows you to track vehicles, owners, drivers and causes of accident caused by public transport in Namibia</p>
        </div>
        <img class="img-thumbnail" src="img/nabta_logo.jpg" alt="">
    </body>
</html>
