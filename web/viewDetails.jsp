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
        <title>View Vehicles</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- JQuery (necessary for Bootstrap's JavaScript plugins) -->
        <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>-->
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <ul class="nav nav-pills">
            <li role="presentation"><a href="index.jsp">Home</a></li>
            <li role="presentation"><a href="agreement.jsp">Register Vehicle</a></li>
            <li role="presentation" class="active"><a href="viewDetails.jsp">View Registered Vehicle</a></li>
            <li role="presentation"><a href="reports.jsp">Reports</a></li>
        </ul>
        <form action="View" method="POST">
            <table border="0">
                <tbody>
                 <tr>
                <td>Search by: </td>
                <td>
                    <select name="option">
                        <option>Vehicle Registration</option>
                        <option>Owner's ID number</option>
                        <option>Driver's ID number</option>
                    </select>
                    <input type="text"  name="search" placeholder="type search term here" value="" />
                    <input class="btn btn-default" type="submit" value="View Vehicle" />
                </td>
                </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
