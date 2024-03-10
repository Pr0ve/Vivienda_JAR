/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Vivienda;

/**
 *
 * @author DAW TARDE
 */
public interface Vivienda extends Comparable<Vivienda> {
    
    public double getSuperficie();
    public double getPrecio();
    public Operacion getOperacion();
    public String getDireccion();
    public void setSuperficie(double superficie);
    public void setPrecio(double precio);
    public void setOperacion(Operacion operacion);
    public void setDireccion(String direccion);
    public double calculaRebajaPrecioVivienda10();
    public boolean esViviendaDeEsaOperacion(Operacion tipoOperacion);
    public double calculaBeneficioPorGestionParaLaInmobiliaria();
    public double calculaPrecioPorMetroCuadrado();
    public String getDireccionViviendaMasCaraPorMetroCuadradoSiCompartenOperacion(Vivienda vivienda);
    public String calculaTamanioVivienda();
    public String getLocalidadDeVivienda();
    public double calculaSuperficieTotal(double[] superficies);
}
