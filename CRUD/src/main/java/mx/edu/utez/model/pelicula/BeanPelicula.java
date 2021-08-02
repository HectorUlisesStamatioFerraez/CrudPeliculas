package mx.edu.utez.model.pelicula;

public class BeanPelicula {

    private long id;
    private  String nombrePelicula;
    private String descripcion; 
    private String fechaDeEstreno;
    private Double recaudacion;
    private int estado; 

    public BeanPelicula(long id, String nombrePelicula, String descripcion, String fechaDeEstreno, Double recaudacion, int estado) {
    this.id = id;
    this.nombrePelicula = nombrePelicula;
    this.descripcion = descripcion;
    this.fechaDeEstreno = fechaDeEstreno;
    this.recaudacion = recaudacion;
    this.estado = estado;
    }

    public BeanPelicula() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombrePelicula() { return nombrePelicula; }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaDeEstreno() {
        return fechaDeEstreno;
    }

    public void setFechaDeEstreno(String fechaDeEstreno) {
        this.fechaDeEstreno = fechaDeEstreno;
    }

    public Double getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(Double recaudacion) {
        this.recaudacion = recaudacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}