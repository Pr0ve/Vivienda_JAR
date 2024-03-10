/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Catalogo;

import Excepciones.CatalogoException;
import Vivienda.Piso;
import java.util.List;

/**
 *
 * @author javie
 */
public interface Catalogo {

    void aniadePiso(Piso piso) throws CatalogoException;

    void añadeRebajaSiPisoEsMayorQueSuperficie(int porcentajeRebaja, double superficie);

    double calculaPrecioTotalDePlanta(int planta);

    int cuentaPisoPorOperacion(String tipoOperacion) throws CatalogoException;

    void eliminaPiso(Piso piso) throws CatalogoException;

    boolean esLaPlantaMasAlta(int planta);

    List<Piso> getCatalogo();

    String getDireccionPisoConMenorPrecioPorSuperficie();

    List<Piso> getPisosSuperficieMayorPrecioMenor(double superficie, double precio);

    boolean hayPisoMasBarato(double precio);

    void ordenaCatalogoPorSuperficieAsc();

    void setCatalogo(List<Piso> catalogo);
    
}
