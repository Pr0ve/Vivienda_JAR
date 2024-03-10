/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Catalogo;

import Vivienda.Piso;
import java.util.Comparator;

/**
 *
 * @author javie
 */
public class ComparadorPorPrecio implements Comparator<Piso> {

    @Override
    public int compare(Piso o1, Piso o2) {
        return Double.compare(o1.getPrecio(), o2.getPrecio());
    }
    
}
