<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/2/2021
  Time: 9:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <h2>Edit Nhân Viên</h2>
    <form  method="post">
        <table class="table table-dark table-hover">
            <tbody>
            <tr>
                <td><input placeholder="nhap id" name="id" value="${editnhanvien.id}" readonly></td>
                <td><input placeholder="nhap ten" name="name" value="${editnhanvien.name}"></td>
                <td><input placeholder="nhap birthday" name="birthday" value="${editnhanvien.birthday}"></td>
                <td><input placeholder="nhap dia chi" name="address" value="${editnhanvien.address}"></td>
                <td><input placeholder="nhap sdt" name="sdt" value="${editnhanvien.sdt}"></td>
                <td><input placeholder="nhap email" name="email" value="${editnhanvien.email}"></td>
                <td><input placeholder="nhap phong ban" name="department" value="${editnhanvien.department}"></td>
            </tr>

            </tbody>
        </table>
        <button type="submit" class="btn btn-success">Edit </button>

    </form>
</div>

</body>
</html>
