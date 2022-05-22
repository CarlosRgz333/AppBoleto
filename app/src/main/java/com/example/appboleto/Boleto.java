package com.example.appboleto;

public class Boleto {
    private int id;
    private String nombreCliente;
    private String destino;
    private String tipoViaje;
    private String fecha;
    private float precio;

    private int edad;
    public Boleto(){

    }
    public Boleto(int id, String nombreCliente, String destino, String tipoViaje, String fecha, float precio){
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.destino = destino;
        this.tipoViaje = tipoViaje;
        this.fecha = fecha;
        this.precio = precio;
    }

    public Boleto(Boleto boleto){
        this.id = boleto.id;
        this.nombreCliente = boleto.nombreCliente;
        this.destino = boleto.destino;
        this.tipoViaje = boleto.tipoViaje;
        this.fecha = boleto.fecha;
        this.precio = boleto.precio;
    }
    //Encapsulamiento (SET´s & GET´s) | Metodos de propiedad
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombreCliente() {
        return nombreCliente;
    }
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public String getTipoViaje() {
        return tipoViaje;
    }
    public void setTipoViaje(String tipoViaje) {
        this.tipoViaje = tipoViaje;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public double calcularSubtotal(){
        double subtotal=0;
        if(tipoViaje.equalsIgnoreCase("sencillo")){
            subtotal=precio;
        }else if(tipoViaje.equalsIgnoreCase("doble")){
            subtotal=precio+(precio*.8);
        }
        return subtotal;
    }
    public double calcularImpuesto(){
        double impuesto;
        impuesto = calcularSubtotal()*.16;
        return impuesto;
    }
    public double calcularDescuento(int edad){

        double descuento=0;


        if(edad>60){
            descuento = (calcularSubtotal()+calcularImpuesto())*.5;
        }
        return descuento;
    }
    public double calcularPagoTotal(){
        double pagoTotal;
        pagoTotal = (calcularSubtotal()+calcularImpuesto())-calcularDescuento(getEdad());
        return pagoTotal;
    }

    public String imprimirImporte(){
        return "\n\n\t--Importe--\n\nSubtotal = \t\t"+calcularSubtotal()+"\nImpuesto 16% (+) = \t\t"+calcularImpuesto()+"\nDescuento (-) = \t\t"+calcularDescuento(getEdad())+"\nTotal a Pagar = \t\t"+calcularPagoTotal()+"";
    }

    public String imprimirBoleto(){
        return "\n\n\t--Datos del Cliente--"+"\n\nId: \t\t"+getId()+"\nNombre Cliente: \t\t"+getNombreCliente()+"\nDestino: \t\t"+getDestino()+"\nTipo de Viaje: \t\t"+getTipoViaje()+"\nFecha: \t\t"+getFecha()+"\nPrecio: \t\t"+getPrecio()+imprimirImporte()+"\n\n";
    }


}
