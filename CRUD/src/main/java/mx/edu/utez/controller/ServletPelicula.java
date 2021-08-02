package mx.edu.utez.controller;

import mx.edu.utez.model.pelicula.BeanPelicula;
import mx.edu.utez.model.pelicula.DaoPelicula;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletPelicula", urlPatterns = {"/readPelicula", "/createPelicula", "/getPeliculaById", "/updatePelicula", "/deletePelicula"})
public class ServletPelicula extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(ServletPelicula.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listaPelicula", new DaoPelicula().findAll());
        request.getRequestDispatcher("../webapp/views/pelicula/pelicula.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        switch(action){
            case "create":
                String nombrePelicula = request.getParameter("nombrePelicula") != null ? request.getParameter("nombrePelicula") : "";
                String descripcion = request.getParameter("descripcion");
                String fechadeEstreno = request.getParameter("fechadeEstreno");
                double recaudacion = Integer.parseInt(request.getParameter("recaudacion"));
                BeanPelicula beanPelicula = new BeanPelicula(1,nombrePelicula, descripcion, fechadeEstreno, recaudacion, 1);
                if(new DaoPelicula().create(beanPelicula)){
                    request.setAttribute("message", "La pelicula fue registrada correctamente");
                } else {
                    request.setAttribute("message", "La pelicula no fue registrada");
                }
                doGet(request, response);
                break;

            case "getPeliculaById":
                long id = Long.parseLong(request.getParameter("id"));
                request.setAttribute("pelicula", new DaoPelicula().findById(id));
                request.getRequestDispatcher("../webapp/views/pelicula/update.jsp").forward(request, response);
                break;
            case "update":
                long idUno = Long.parseLong(request.getParameter("id"));
                String nombreUno = request.getParameter("nombrePelicula") != null ? request.getParameter("nombrePelicula") : "";
                String descripcionUno = request.getParameter("descripcion");
                String fechadeEstrenoUno = request.getParameter("fechadeEstreno");
                double recaudacionUno = Integer.parseInt(request.getParameter("recaudacion"));

                BeanPelicula beanPeliculaUno = new BeanPelicula(idUno, nombreUno, descripcionUno, fechadeEstrenoUno, recaudacionUno, 1);

                if(new DaoPelicula().update(beanPeliculaUno)){
                    request.setAttribute("message", "La pelicula fue modificada correctamente");
                } else {
                    request.setAttribute("message", "La pelicula no fue modificada correctamente");
                }
                doGet(request, response);
                break;
            case "delete":
                long id2 = Long.parseLong(request.getParameter("id"));
                if(new DaoPelicula().delete(id2)){
                    request.setAttribute("message", "El usuario fue eliminado correctamente");
                } else {
                    request.setAttribute("message", "El usuario no fue eliminado correctamente");
                }
                doGet(request, response);
                break;
            default:

                break;
        }
    }
}
