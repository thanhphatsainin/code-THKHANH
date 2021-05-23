<%-- 
    Document   : addToy
    Created on : Oct 27, 2020, 10:32:13 AM
    Author     : QuangPro99
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="doAddToy.jsp">
            <h1>THÊM TOY</h1>
            <br>
            <table>
                <tr>
                    <td>ID: </td>
                    <td><input type="text" name="id" placeholder="234"></td>
                </tr>
                
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="name"></td>
                </tr>
                
                <tr>
                    <td>Price </td>
                    <td><input type="text" name="price"></td>
                </tr>
                
                <tr>
                    <td>Description </td>
                    <td><input type="text" name="description"></td>
                </tr>
                
                <tr>
                    <td>Dos </td>
                    <td><input type="text" name="dos" placeholder="yyyy/MM/dd"></td>
                </tr>
                
                <tr>
                    <td>Avg </td>
                    <td><input type="text" name="avg"></td>
                </tr>
                
                <tr>
                    <td>Image </td>
                    <td><input type="text" name="image" placeholder="img/..."></td>
                </tr>
                
            </table>
            
            <input type="submit" value="ADD NEW TOY">
            <input type="reset" value="RESET">
            
        </form>
    </body>
</html>
