<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/2/2021
  Time: 9:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Quản Lý Nhân Viên</h2>
    <a href="/nhanvien?action=create" class="btn btn-success">Create</a>
    <table class="table table-dark table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Address</th>
            <th>SDT</th>
            <th>Email</th>
            <th>Department</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
         <c:forEach items="${newnhanvien}" var="nhanvien" varStatus="loop">
             <tr>
                 <td>${nhanvien.id}</td>
                 <td>${nhanvien.name}</td>
                 <td>${nhanvien.birthday}</td>
                 <td>${nhanvien.address}</td>
                 <td>${nhanvien.sdt}</td>
                 <td>${nhanvien.email}</td>
                 <td>${nhanvien.department}</td>
                 <td><a href="/nhanvien?action=edit&index=${loop.index}" class="btn btn-warning">Edit</a></td>
                 <td><a href="/nhanvien?action=delete&index=${loop.index}" class="btn btn-danger">Delete</a></td>
             </tr>
         </c:forEach>


        </tbody>
    </table>
    <form action="/nhanvien?action=find" method="get">
        <input type="text" class="form-control" placeholder="find name" name="find">
        <input type="text" hidden name="action" value="find">
        <button type="submit" class="btn btn-success">Find</button>

    </form>

</div>

</body>
</html>
