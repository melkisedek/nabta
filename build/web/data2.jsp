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
        <h3>Continue by Filling in the vehicle information Below</h3>
        <form action="Confirm"  method="POST"> 
            <table border="0"> 
                <tbody> 
                    <tr> 
                        <td>Owner's ID:</td> 
                        <td><input type="text" name="ownerID" value="" required/></td> 
                    </tr> 

                    <tr> 
                        <td>Driver's ID:</td> 
                        <td><input type="text" name="driverID" value="" required/></td> 
                    </tr> 
                    <tr> 
                        <td>Postal Address:</td> 
                        <td><input type="text" name="postAddr" value="" required/></td> 
                    </tr> 
                    <tr> 
                        <td>Residential Address:</td> 
                        <td><input type="text" name="residentAddr" value="" required></td> 
                    </tr>                   
                    <tr> 
                        <td>Region:</td> 
                        <td><input type="text" name="region" value="" required/></td> 
                    </tr> 
                </tbody> 
            </table>
            <!--return to previous page-->
            <button onclick="goBack()">Go Back</button>
            <script>
                function goBack() {
                    window.history.back();
                }
            </script>
            <input class="btn btn-default" type="submit" value="Finish"/>    
        </form> 
    </body> 
</html> 