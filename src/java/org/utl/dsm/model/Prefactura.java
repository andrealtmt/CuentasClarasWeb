package org.utl.dsm.model;

import java.sql.Date;

public class Prefactura {
    private int idPrefactura;
    private String proveedor;
    private Date fechaEmision;
    private int idPersonaFisica;
    private ProductoServicio[] material;

    public Prefactura() {
    }

    public Prefactura(int idPrefactura, String proveedor, Date fechaEmision, int idPersonaFisica, ProductoServicio[] material) {
        this.idPrefactura = idPrefactura;
        this.proveedor = proveedor;
        this.fechaEmision = fechaEmision;
        this.idPersonaFisica = idPersonaFisica;
        this.material = material;
    }

    public ProductoServicio[] getMaterial() {
        return material;
    }

    public void setMaterial(ProductoServicio[] material) {
        this.material = material;
    }
    
    public int getIdPrefactura() {
        return idPrefactura;
    }

    public void setIdPrefactura(int idPrefactura) {
        this.idPrefactura = idPrefactura;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public int getIdPersonaFisica() {
        return idPersonaFisica;
    }

    public void setIdPersonaFisica(int idPersonaFisica) {
        this.idPersonaFisica = idPersonaFisica;
    }

    @Override
    public String toString() {
        return "Prefactura{" +
                "idPrefactura=" + idPrefactura +
                ", proveedor='" + proveedor + '\'' +
                ", fechaEmision=" + fechaEmision +
                ", idPersonaFisica=" + idPersonaFisica +
                '}';
    }
}

