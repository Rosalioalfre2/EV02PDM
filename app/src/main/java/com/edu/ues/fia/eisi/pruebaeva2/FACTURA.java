package com.edu.ues.fia.eisi.pruebaeva2;

public class FACTURA {
    public String getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNumfactura() {
        return numfactura;
    }

    public void setNumfactura(String numfactura) {
        this.numfactura = numfactura;
    }

    public Float getMontoventa() {
        return montoventa;
    }

    public void setMontoventa(Float montoventa) {
        this.montoventa = montoventa;
    }

    public FACTURA(String idcliente, String idArticulo, String numfactura, Float montoventa) {
        this.idcliente = idcliente;
        this.idArticulo = idArticulo;
        this.numfactura = numfactura;
        this.montoventa = montoventa;
    }

    public FACTURA() {
    }

    String idcliente;
    String idArticulo;
    String numfactura;
    Float montoventa;
}
