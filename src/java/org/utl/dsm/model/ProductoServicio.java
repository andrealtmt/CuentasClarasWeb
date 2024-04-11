package org.utl.dsm.model;

public class ProductoServicio {
    private int idProductoServicio;
    private double precioUnitario;
    private String descripcion;
    private double precioFinal;

    public ProductoServicio() {
    }

    public ProductoServicio(int idProductoServicio, double precioUnitario, String descripcion, double precioFinal) {
        this.idProductoServicio = idProductoServicio;
        this.precioUnitario = precioUnitario;
        this.descripcion = descripcion;
        this.precioFinal = precioFinal;
    }

    public int getIdProductoServicio() {
        return idProductoServicio;
    }

    public void setIdProductoServicio(int idProductoServicio) {
        this.idProductoServicio = idProductoServicio;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    @Override
    public String toString() {
        return "ProductoServicio{" +
                "idProductoServicio=" + idProductoServicio +
                ", precioUnitario=" + precioUnitario +
                ", descripcion='" + descripcion + '\'' +
                ", precioFinal=" + precioFinal +
                '}';
    }
}


