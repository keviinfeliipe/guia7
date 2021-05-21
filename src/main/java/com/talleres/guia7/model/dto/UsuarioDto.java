package com.talleres.guia7.model.dto;

public class UsuarioDto {

    private String nroID;
    private String tipoID;
    private String nombres;
    private String correo;
    private String celular;

    public UsuarioDto() {
    }

    public UsuarioDto(String nroID, String tipoID, String nombres, String correo, String celular) {
        this.nroID = nroID;
        this.tipoID = tipoID;
        this.nombres = nombres;
        this.correo = correo;
        this.celular = celular;
    }

    public String getNroID() {
        return nroID;
    }

    public void setNroID(String nroID) {
        this.nroID = nroID;
    }

    public String getTipoID() {
        return tipoID;
    }

    public void setTipoID(String tipoID) {
        this.tipoID = tipoID;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "UsuarioDto{" +
                "nroID='" + nroID + '\'' +
                ", tipoID='" + tipoID + '\'' +
                ", nombres='" + nombres + '\'' +
                ", correo='" + correo + '\'' +
                ", celular='" + celular + '\'' +
                '}';
    }
}
