package com.edu.ues.fia.eisi.pruebaeva2;

public class ARTICULO {

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNomArticulo() {
        return nomArticulo;
    }

    public void setNomArticulo(String nomArticulo) {
        this.nomArticulo = nomArticulo;
    }

    public String getTipoArticulo() {
        return tipoArticulo;
    }

    public void setTipoArticulo(String tipoArticulo) {
        this.tipoArticulo = tipoArticulo;
    }

    public ARTICULO() {
    }

    String idArticulo;
    String nomArticulo;
    String tipoArticulo;
    public ARTICULO(String idArticulo, String nomArticulo, String tipoArticulo) {
        this.idArticulo = idArticulo;
        this.nomArticulo = nomArticulo;
        this.tipoArticulo = tipoArticulo;
    }

}
