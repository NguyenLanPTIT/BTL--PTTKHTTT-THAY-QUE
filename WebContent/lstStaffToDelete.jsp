<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.shashi.beans.UserBean, com.shashi.service.UserService, com.shashi.service.impl.UserServiceImpl, java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<title>View Staff</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<style>
    body {
        background-color: #F4F7F6;
    }
    .container{
		display : flex ;
         justify-content: center;
         align-items: center;
          flex-direction: column;
          }
    .tab {
        margin: 20px auto;
        padding: 20px;
        background-color: #FFFFFF;
        border-radius: 8px;
        width: 80%;
        text-align: center;
        box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
    }
    .tab  h2{
  	  font-weight: bold;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin: 20px auto;
    }
    th, td {
       border: 1px solid #000;
        padding: 8px !important;
        text-align: center !important;
    }
    th {
       background-color: #4CAF50;
        color: white;
        font-size : 18px;
    }
     td{
  	  font-size : 14px;
    }
    .btn-update {
        background-color: #007BFF;
        color: white;
        border: none;
        padding: 5px 10px !important;
        border-radius: 4px;
        cursor: pointer;
    }
    .btn-update:hover {
        background-color: #0056b3;
        padding: 5px 10px !important;
    }
</style>
</head>
<body>
    <!-- Header -->
    	<jsp:include page="header.jsp" />
    <div class="container">
        <h2>Admin Management Panel</h2>
    <div class="tab">
        <h2>Staff List</h2>
        <%
            UserService userService = new UserServiceImpl();
            List<UserBean> staffList = userService.getAllStaff();
        %>
        <table>
            <tr>
                <th>Email</th>
                <th>Name</th>
                <th>Mobile</th>
                <th>Address</th>
                <th>Pincode</th>
                
                <th>Password</th>
                <th>Role</th>
                <th>Position</th>
                <th>Action</th>
            </tr>
            <%
                for (UserBean user : staffList) {
            %>
            <tr>
                <td><%= user.getEmail() %></td>
                <td><%= user.getName() %></td>
                <td><%= user.getMobile() %></td>
                <td><%= user.getAddress() %></td>
                <td><%= user.getPinCode() %></td>
                <td><%= user.getPassword() %></td>
                <td><%= user.getRole() %></td>
                <td><%= user.getPosition() %></td>
                <td>
                    <form action="./DeleteStaffSrv" method="post">
                        <input type="hidden" name="email" value="<%= user.getEmail() %>">
                        <input type="hidden" name="name" value="<%= user.getName() %>">
                        <input type="hidden" name="mobile" value="<%= user.getMobile() %>">
                        <input type="hidden" name="address" value="<%= user.getAddress() %>">
                        <input type="hidden" name="pincode" value="<%= user.getPinCode() %>">
                        <input type="hidden" name="password" value="<%= user.getPassword() %>">
                        <input type="hidden" name="position" value="<%= user.getPosition() %>">
                        <button type="submit" class="btn-update">Delete Staff</button>
                    </form>
                </td>
            </tr>
            <%
                }
            %>
        </table>
         <br>
        <a href="manageStaff.jsp" class="btn btn-default" style="width: 100%; margin-top: 20px;  background-color: #d43f3a;color: #fff;">Back to Manage Staff</a>
    
    </div>
    </div>
    <!-- Footer -->
   	<%@ include file="footer.html"%>
</body>
</html>
