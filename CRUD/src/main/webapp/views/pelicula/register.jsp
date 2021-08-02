<%--
  Created by IntelliJ IDEA.
  User: Ulises
  Date: 29/07/2021
  Time: 10:39 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Registrar una Pelicula</title>
    <link rel="stylesheet" href="${context}/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
</head>
<body>
    <h1>Registrar una Pelicula</h1>
    <form action="${context}/createPelicula" method="POST">
        <input type="hidden" value="create" name="action">
        <label>Nombre de la pelicula: </label>
        <input class="form-control" type="text" name="nombrePelucla" />
        <br>
        <label>Descripción: </label>
        <input class="form-control" type="text" name="descripcion" />
        <br>
        <label>Fecha de Estreno: </label>
        <input class="form-control" type="date" name="fechadeEstreno" />
        <br>
        <label>Recaudación conseguida: </label>
        <input class="form-control" type="number" name="recaudacion" />
        <br>  

        <button type="button" class="btn btn-danger"><i class="fas fa-times"></i> Cancelar</button>
        <button type="submit" class="btn btn-success"><i class="fas fa-plus"></i> Agregar</button>
    </form>

    <script src="${context}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</body>
</html>
