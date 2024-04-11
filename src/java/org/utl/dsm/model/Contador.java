package org.utl.dsm.model;

public class Contador extends Persona{
    private int idContador;
    private String correo;
    private String whatsapp;
    private Usuario usuario;
    
    
    public Contador() {
    }

    public Contador(int idContador, String correo, String whatsapp, Usuario usuario) {
        this.idContador = idContador;
        this.correo = correo;
        this.whatsapp = whatsapp;
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
    public int getIdContador() {
        return idContador;
    }

    public void setIdContador(int idContador) {
        this.idContador = idContador;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    @Override
    public String toString() {
        return "Contador{" +
                "idContador=" + idContador +
                ", correo='" + correo + '\'' +
                ", whatsapp='" + whatsapp + '\'' +
                '}';
    }
}

