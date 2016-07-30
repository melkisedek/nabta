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
            <li role="presentation" class="active"><a href="agreement.jsp">Register Vehicle</a></li>
            <li role="presentation"><a href="viewDetails.jsp">View Registered Vehicle</a></li>
            <li role="presentation"><a href="reports.jsp">Reports</a></li>
        </ul>
        <h3>Fill in the vehicle information Below</h3>
        <form action="Data2" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Owner's First name(s):</td>
                        <td><input type="text" name="ownerNames" value="" placeholder="Owner's Name(s)" required/></td>
                    </tr>
                    <tr>
                        <td>Owner's Surname:</td>
                        <td><input type="text" name="ownerSurname" value="" placeholder="Owner's Surname" required/></td>
                    </tr>
                    <tr>
                        <td>Driver's Name(s):</td>
                        <td><input type="text" name="driverNames" value="" placeholder="Driver's Name(s)" required/></td>
                    </tr>
                    <tr>
                        <td>Driver's Surname:</td>
                        <td><input type="text" name="driverSurname" value="" placeholder="Driver's Surname" required/></td>
                    </tr>
                    <tr>
                        <td>Registration Number:</td>
                        <td><input type="text" name="regNum" value="" required/></td>
                    </tr>
                    <tr>
                        <td>NBTA ID number:</td>
                        <td><input type="text" name="nbtaID" value="" required/></td>
                    </tr>
                    <tr>
                        <td>Type: </td>
                        <td>
                            <select name="type">
                                <option>Taxi</option>
                                <option>Minibus</option>
                                <option>Bus</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Vehicle Model:</td>
                        <td><input type="text" name="model" value="" required/></td>
                    </tr>
                    <tr>
                        <td>Mass(in kg):</td>
                        <td><input type="text" name="mass" value="" required/></td>
                    </tr>
                    <tr>
                        <td>Colour:</td>
                        <td><input type="text" name="color" value="" required/></td>
                    </tr>
                    <tr>
                        <td>Cause Of Accident:</td>
                        <td>
                            <textarea name="cause" placeholder="State cause of accident here."></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>Place</td>
                        <td><input type="text" name="place" value="" /></td>
                    </tr>
                    <tr>
                        <td>Date of Accident</td>
                        <td><input type="date" name="date" value=""/></td>
                    </tr>
                </tbody>
            </table>
            <input class="btn btn-default" type="submit" value="Continue" />   
        </form>
    </body>
</html>
