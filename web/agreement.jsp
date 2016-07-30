<%-- 
    Document   : agreement
    Created on : 29-Apr-2015, 13:04:27
    Author     : mel
--%>
<%@page import= "java.util.Date" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html> 
    <head> 
        <link rel="icon" type="image/ico" href="img/favicon.ico">
        <title>Agreement</title> 
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
            <li role="presentation" class="active"><a href="agreement.jsp">Register Vehicle</a></li> 
            <li role="presentation"><a href="viewDetails.jsp">View Registered Vehicle</a></li> 
            <li role="presentation"><a href="reports.jsp">Reports</a></li> 
        </ul> 
        <h1>Terms and conditions</h1>
        <iframe src="agreement.txt" width="450" height="250"></iframe>
    <form action="data1" method="POST">
        <table border="0">
            <tbody>
                <tr>
                    <td> <input type=checkbox name="Astate" value="agreed">Agree to terms and conditions</td>
                    <td><input class="btn btn-default" type="submit" value="OK" /></td>
                </tr>
            </tbody>
        </table>
    </form>
    </body>
</html>
