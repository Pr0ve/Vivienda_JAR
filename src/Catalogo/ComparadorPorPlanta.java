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
public class ComparadorPorPlanta implements Comparator<Piso> {

    public int compare(Piso o1, Piso o2) {
        return Integer.compare(o2.getPlanta(), o1.getPlanta());
    }
    
}
