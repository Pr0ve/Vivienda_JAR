/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vivienda;


import Excepciones.PrecioNegativoExcepcion;
import Vivienda.Vivienda;

/**
 *
 * @author Javi
 */
public class ViviendaImpl implements Vivienda{
    
    private static final int REBAJA = 10;
    private static final double BENEFICIO_ALQUILER = 0.08;
    private static final double BENEFICIO_VENTA = 0.14;
    private static final double BENEFICIO_ALQUILER_OPCION_COMPRA = 0.11;
            
//EJERCICIO 1
    
    protected double superficie;
    protected double precio;
    protected Operacion operacion;
    protected String direccion;

    
    public double getSuperficie() {
        return superficie;
    }

    public double getPrecio() {
        return precio;
    }

    public Operacion getOperacion() {
        return operacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public void setPrecio(double precio) {
        try{
            compruebaPrecio(precio);
            this.precio = precio;
        }catch(PrecioNegativoExcepcion e){
            System.out.println(e);
        }
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


//EJERCICIO 2    
    public ViviendaImpl(double superficie, double precio, Operacion operacion, String direccion) {
        this.superficie = superficie;
        try{
            compruebaPrecio(precio);
            this.precio = precio;
        }catch(PrecioNegativoExcepcion e){
            System.out.println(e);
        }
        this.operacion = operacion;
        this.direccion = direccion;
    }
    
    public ViviendaImpl(String direccion) {
        this.superficie = 90.0;
        this.precio = 150000.00;
        this.operacion = Operacion.VENTA;
        this.direccion = direccion;
    }
    
     public ViviendaImpl() {
        this.superficie = 90.0;
        this.precio = 150000.0;
        this.operacion = Operacion.VENTA;
        this.direccion = ""; 
    }
    
   
//EJERCICIO 3
     /**
      * Calcula el precio en el que se queda la vivienda despues de aplicar la rebaja
      * @return precio double de la vivienda despues de apicar la rebaja 
      */
    public double calculaRebajaPrecioVivienda10(){
        return this.getPrecio()-(this.getPrecio()/100*REBAJA);
    }

//EJERCICIO 4
    public String toString() {
        return "Dirección: " + direccion + " - precio=" + precio + " - superficie=" + superficie + " - operación=" + operacion;
    }
    
//EJERCICIO 5
    /**
     * Verifica si el tipo de operación que tiene nuestra vivienda como atributo coincide con la que le introducimos por parametro 
     * @param tipoOperacion Define el tipo que va a ser la operacion
     * @return Devuelve un booleano true en el caso de que el valor del atributo coincida con el parametro de entrada y false si no coincide
     */
    public boolean esViviendaDeEsaOperacion(Operacion tipoOperacion){
        return this.getOperacion().equals(tipoOperacion);
    }
    
//EJERCICIO 6
    /**
     * Calcula el beneficio que obtiene la inmobiliaria por cada vivienda dependiendo de la operación que se realize
     * @return Devuelve un double que es el dinero que se lleva la inmobiliaria
     */
    public double calculaBeneficioPorGestionParaLaInmobiliaria(){
        double d = 0.0;
        
        if(this.operacion.equals(Operacion.ALQUILER)){
            d = this.precio * BENEFICIO_ALQUILER;
        }
        else if(this.operacion.equals(Operacion.VENTA)){
            d = this.precio * BENEFICIO_VENTA;
        }
        else if(this.operacion.equals(Operacion.ALQUILER_CON_OPCION_A_VENTA)){
            d = this.precio * BENEFICIO_ALQUILER_OPCION_COMPRA;
        }
        return d;
    }
    
//EJERCICIO 7
    /**
     * Calcula el precio por metro cuadrado de una vivienda
     * @return Devuelve un double que es el dinero que cuesta un metro cuadrado
     */
    public double calculaPrecioPorMetroCuadrado(){
        return this.precio / this.superficie;
    }
    
    /**
     * Compara que las 2 viviendas compartan operación y en ese caso devuelve la direccion de la casa con el metro cuadrado mas caro, en caso contrario de que no compartan operacion devuelve un String que lo comunica
     * @param vivienda Es un objeto del tipo vivienda
     * @return Devuelve un String que puede ser de la direccion de el objeto desde al que hemos llamado al metodo o desde el parametro de entrada, tambien pueden devolver dos mensajes, uno que diga que las casas tienen el mismo precio por metro cuadrado y otro que diga que no comparten operacion
     */
    public String getDireccionViviendaMasCaraPorMetroCuadradoSiCompartenOperacion(Vivienda vivienda){
        String s = "";
        
        if(this.operacion.equals(vivienda.getOperacion())){
            if(this.calculaPrecioPorMetroCuadrado()<vivienda.calculaPrecioPorMetroCuadrado()){
                s = vivienda.getDireccion();
            }
            else if(this.calculaPrecioPorMetroCuadrado()>vivienda.calculaPrecioPorMetroCuadrado()){
                s = this.direccion;
            }
            else{
                s = "Las dos viviendas tienen el mismo precio por metro cuadrado";
            }
        }
        else{
            s = "Las viviendas no tienen la misma operación";
        }
        return s;
    }
    
//EJERCICIO 8
    /**
     * Obtiene el tamaño de la vivienda a traves de varios valores predefinidos
     * @return Devuelve un String que indica el tamaño de la vivienda
     */
    public String calculaTamanioVivienda(){
        String s = "";
        
        if(this.superficie<70){
            s = "Vivienda pequeña";
        }
        else if(this.superficie>=70 && this.superficie<=90){
            s = "Vivienda mediana";
        }
        else{
            s = "Vivienda grande";
        }
        return s;
    }
    
//EJERCICIO 9
    /**
     * Obtiene la localidad de la dirección
     * @return Devuelve un String que indica la localidad
     */
    public String getLocalidadDeVivienda(){
        String[] array = this.direccion.split(", ");
        String s = "";
        
        for(int i=1;i<array.length;i++){
            s = array[i];
        }
        return s;
    }
    
//EJERCICIO 10
    /**
     * Calcula la superficie total de la vivienda sumando todos los elementos del parametro de entrada que son los tamaños de las partes de la vivienda
     * @param superficies Es un array de double que contiene todas las medidas en metros cuadrados de todas las partes de la vivienda
     * @return Devuelve un double con la superficie total de la vivienda en metros cuadrados
     */
    public double calculaSuperficieTotal(double[] superficies){
        double o = 0;
        
        for(double elements:superficies){
            o = o + elements;
        }
        
        this.superficie = o;    
        
        return this.superficie;
    }
    
    public boolean equals(Object o){
        boolean r = false;
        if(o instanceof Vivienda){
            Vivienda v = (Vivienda) o;
            r = this.getDireccion().equals(v.getDireccion());
        }
        return r;
    }
    
    /**
     * Comprueba que los precios metidos por parametro no sean inferiores a 0, en tal caso el metodo lanzara una excepcion
     * @param precio Es un double que es el que el metodo va a comprobar que no sea inferior a 0
     */
    public static void compruebaPrecio(double precio) throws PrecioNegativoExcepcion{
        if(precio < 0){
            throw new PrecioNegativoExcepcion("El precio no puede ser negativo");
        }
    }

    public int compareTo(Vivienda o) {
        return this.direccion.compareTo(o.getDireccion());
    }
    
    
}
