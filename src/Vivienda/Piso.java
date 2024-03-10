/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Vivienda;

/**
 *
 * @author javie
 */
public interface Piso extends Vivienda, Comparable<Vivienda> {

    int getPlanta();

    char getPuerta();
    
}
