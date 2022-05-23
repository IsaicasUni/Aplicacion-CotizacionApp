package com.example.cotizacionapp;

public class Cotizacion {

    //ATRIBUTOS
    private int numCotizacion;
    private String descripcion;
    private double precio;
    private double porcentajeInicial;
    private int plazo;

    // Constructor vacío
    public Cotizacion() {
        this.numCotizacion=0;
        this.descripcion="";
        this.precio=0.0;
        this.porcentajeInicial=0.0;
        this.plazo=0;
    }

    // Constructor de parámetros
    public Cotizacion(int numCotizacion, String descripcion, double precio, double porcentajeInicial, int plazo) {
        this.numCotizacion = numCotizacion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.porcentajeInicial = porcentajeInicial;
        this.plazo = plazo;
    }

    // Constructor de copia
    public Cotizacion(Cotizacion coti) {
        this.numCotizacion = coti.numCotizacion;
        this.descripcion = coti.descripcion;
        this.precio = coti.precio;
        this.porcentajeInicial = coti.porcentajeInicial;
        this.plazo = coti.plazo;
    }

    public int getNumCotizacion() {
        return numCotizacion;
    }

    public void setNumCotizacion(int numCotizacion) {
        this.numCotizacion = numCotizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPorcentajeInicial() {
        return porcentajeInicial;
    }

    public void setPorcentajeInicial(double porcentajeInicial) {
        this.porcentajeInicial = porcentajeInicial;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public double calcularPagoInicial() {
        double pagoInicial = 0.0f;
        pagoInicial = (this.precio * this.porcentajeInicial) / 100;
        return pagoInicial;
    }

    public double calcularTotalFinanciar() {
        return this.precio - this.calcularPagoInicial();
    }

    public double calcularPagoMensual() {
        return this.calcularTotalFinanciar() / this.plazo;
    }

}
