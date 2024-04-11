package org.utl.dsm.model;

public class PersonaFisica extends Persona{
    private int idPersonaFisica;
    private String rfc;
    private String calle;
    private int numeroExterior;
    private String colonia;
    private int codigoPostal;
    private String ciudad;
    private String estado;
    private String curp;
    private String situacionFiscal;
    private Usuario usuario;

    public PersonaFisica() {
    }

    public PersonaFisica(int idPersonaFisica, String rfc, String calle, int numeroExterior, String colonia,
                         int codigoPostal, String ciudad, String estado, String curp, String situacionFiscal,
                         Usuario usuario) {
        this.idPersonaFisica = idPersonaFisica;
        this.rfc = rfc;
        this.calle = calle;
        this.numeroExterior = numeroExterior;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.estado = estado;
        this.curp = curp;
        this.situacionFiscal = situacionFiscal;
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    public int getIdPersonaFisica() {
        return idPersonaFisica;
    }

    public void setIdPersonaFisica(int idPersonaFisica) {
        this.idPersonaFisica = idPersonaFisica;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(int numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getSituacionFiscal() {
        return situacionFiscal;
    }

    public void setSituacionFiscal(String situacionFiscal) {
        this.situacionFiscal = situacionFiscal;
    }

    @Override
    public String toString() {
        return "PersonaFisica{" +
                "idPersonaFisica=" + idPersonaFisica +
                ", rfc='" + rfc + '\'' +
                ", calle='" + calle + '\'' +
                ", numeroExterior=" + numeroExterior +
                ", colonia='" + colonia + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", ciudad='" + ciudad + '\'' +
                ", estado='" + estado + '\'' +
                ", curp='" + curp + '\'' +
                ", situacionFiscal='" + situacionFiscal + '\'' +
                '}';
    }
}

