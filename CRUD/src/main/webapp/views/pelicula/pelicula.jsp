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
    <title>Lista de peliculas</title>
    <link rel="stylesheet" href="${context}/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${context}/assets/dist/css/styles.css">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
</head>
<body>
    <a href="${context}/views/pelicula/register.jsp" class="btn btn-outline-success"><i class="fas fa-plus"></i> Agregar pelicula</a>
    <table class="table">
        <thead class="table-dark">
            <tr>
                <th>Id</th>
                <th>Nombre de la pelicula</th>
                <th>Descripcion</th>
                <th>Fecha de Estreno </th>
                <th>Cantidad recaudada</th>
                <th>Estado de la pelicula </th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${ listaPelicula }" var="nombre" varStatus="estado">
            <tr>
                <td>${ estado.count }</td>
                <td>${ pelicula.id.nombrePelicula } ${ pelicula.id.descripcion }</td>
                <td>${ pelicula.fechaDeEstreno }</td>
                <td>
                    <c:if test="${ pelicula.estado == 1 }">
                        <span class="badge rounded-pill bg-success">Activa</span>
                    </c:if>
                    <c:if test="${ pelicula.estado == 0 }">
                        <span class="badge rounded-pill bg-danger">Inactiva</span>
                    </c:if>
                </td>
                <td>
                    <c:if test="${ pelicula.estado == 1 }">
                        <form action="${context}/getPeliculaById" method="POST" style="display: inline;">
                            <input type="hidden" name="action" value="getPeliculaById">
                            <input type="hidden" name="id" value="${ pelicula.id }">
                            <button type="submit" class="btn btn-outline-primary"><i class="fas fa-edit"></i> Modificar</button>
                        </form>
                        <button id="btn-delete-${ estado.count }" data-code="${ pelicula.id }" data-text="${ pelicula.id.nombrePelicula } ${ pelicula.id.descripcion }" type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#delete"><i class="fas fa-trash"></i> Eliminar</button>
                    </c:if>
                    <c:if test="${ pelicula.estado == 0 }">
                        <button type="button" class="btn btn-info" data-bs-toggle="modal" data-bs-target="#details"><i class="fas fa-info-circle"></i> Detalles</button>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <%-- MODAL --%>
    <div class="modal fade" id="delete" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="${context}/deletePelicula" method="POST">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" id="id">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Eliminar la Pelicula</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <label>¿Deshabilitar?</label>
                        <h5 id="text-delete"></h5>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-warning" data-bs-dismiss="modal"><i class="fas fa-times"></i> Cerrar</button>
                        <button type="submit" class="btn btn-danger"><i class="fas fa-trash"></i> Eliminar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="modal fade" id="details" tabindex="-1" aria-labelledby="exampleModalLabel2" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel2">Detalles de las Peliculas</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <h5>Nombre de la Pelicula: </h5>
                    <label>Godzilla vs King Kong</label>
                    <br>
                    <h5>Descripción: </h5>
                    <label>Una pelicula divertida</label>
                    <br>
                    <h5>Fecha de Estreno: </h5>
                    <label>23/05/2021</label>
                    <br>
                    <h5>Recaudación conseguida: </h5>
                    <label>$1000000</label>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"><i class="fas fa-times"></i> Cerrar</button>
                </div>
            </div>
        </div>
    </div>

    <script src="${context}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="${context}/assets/dist/js/main.js"></script>
</body>
</html>
