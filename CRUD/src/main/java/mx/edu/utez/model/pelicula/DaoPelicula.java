package mx.edu.utez.model.pelicula;

import mx.edu.utez.service.ConnectionMySQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoPelicula {
    Connection con;
    CallableStatement cstm;
    ResultSet rs;
    Logger logger = LoggerFactory.getLogger(DaoPelicula.class);

    public List<BeanPelicula> findAll(){
        List<BeanPelicula> listPelicula = new ArrayList<>();
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_findAll}");
            rs = cstm.executeQuery();
            while(rs.next()){
                BeanPelicula pelicula = new BeanPelicula();
                pelicula.setId(rs.getInt("id"));
                pelicula.setNombrePelicula(rs.getString("nombrePelicula"));
                pelicula.setDescripcion(rs.getString("descripcion"));
                pelicula.setFechaDeEstreno(rs.getString("fechadeEstreno"));
                pelicula.setRecaudacion(rs.getDouble("recaudacion"));
                pelicula.setEstado(rs.getInt("estado"));
                listPelicula.add(pelicula);
            }
        }catch (SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return listPelicula;
    }
    public BeanPelicula findById(long id){
        BeanPelicula ObjPelicula = null;
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("SELECT * FROM pelicula WHERE id = ?");
            cstm.setLong(1, id);
            rs = cstm.executeQuery();
            if(rs.next()){
                ObjPelicula = new BeanPelicula();
                ObjPelicula.setId(rs.getInt("id"));
                ObjPelicula.setNombrePelicula(rs.getString("nombre"));
                ObjPelicula.setDescripcion(rs.getString("descripcion"));
                ObjPelicula.setFechaDeEstreno(rs.getString("fechaEstreno"));
                ObjPelicula.setRecaudacion(rs.getDouble("recaudacion"));
                ObjPelicula.setEstado(rs.getInt("estado"));

            }
        }catch (SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return ObjPelicula;
    }

    public boolean create(BeanPelicula ObjPelicula){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_create(?,?,?,?)}");
            cstm.setString(1, ObjPelicula.getNombrePelicula());
            cstm.setString(2, ObjPelicula.getDescripcion());
            cstm.setString(3, ObjPelicula.getFechaDeEstreno());
            cstm.setDouble(4, ObjPelicula.getRecaudacion());
            cstm.execute();
            flag = true;

        }catch(SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public boolean update(BeanPelicula pelicula){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_update(?,?,?,?,?)}");
            cstm.setInt(1, (int) pelicula.getId());
            cstm.setString(2, pelicula.getNombrePelicula());
            cstm.setString(3, pelicula.getDescripcion());
            cstm.setString(4, pelicula.getFechaDeEstreno());
            cstm.setDouble(5, pelicula.getRecaudacion());
            flag = cstm.execute();
        }catch(SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public boolean delete(long id){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_delete2(?)}");
            cstm.setLong(1, id);
            flag = cstm.execute();
        }catch(SQLException e){
            logger.error("Ha ocurrido un error: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }
}
