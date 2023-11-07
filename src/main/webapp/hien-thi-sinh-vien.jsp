<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 01/11/2023
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>

<form>
    <div class="mb-3">
        <label class="form-label">ID</label>
        <input type="text" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Ho Ten</label>
        <input type="text" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Địa chỉ</label>
        <input type="text" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Giới tính</label>
        <br>
        <input type="radio" id="contactChoice1" name="contact" value="Nam" />
        <label for="contactChoice1">Nam</label>

        <input type="radio" id="contactChoice2" name="contact" value="Nu" />
        <label for="contactChoice2">Nu</label>
    </div>
    <div class="mb-3">
        <label for="disabledSelect" class="form-label">Lớp</label>
        <select id="disabledSelect" class="form-select">
            <option>SD12345</option>
            <option>SD13456</option>
            <option>SD14567</option>
        </select>
    </div>


    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<table class="table">
    <thead>
    <tr>
        <td>STT</td>
        <td>ID</td>
        <td>Tên</td>
        <td>Địa chỉ</td>
        <td>Giới tính</td>
        <td>Lớp</td>
        <td>Action</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="i" items="${listSinhVien}" varStatus="sinhVien">
        <tr>
            <td>${sinhVien.index}</td>
            <td>${i.id}</td>
            <td>${i.ten}</td>
            <td>${i.diaChi}</td>
            <td>${i.gioiTinh}</td>
            <td>${i.lop}</td>
            <td><a href="#" class="btn btn-danger">Xoá</a><a href="#" class="btn btn-primary">Detail</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
