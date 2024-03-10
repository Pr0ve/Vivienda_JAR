/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Catalogo;

import Vivienda.*;
import Excepciones.*;
import java.util.*;


/**
 *
 * @author javie
 */
public class CatalogoImpl implements Catalogo {
    private List<Piso> catalogo;

    public List<Piso> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(List<Piso> catalogo) {
        this.catalogo = catalogo;
    }   
    
    //7    
    /**
     * Cuenta el numero de pisos que comparten operacion con el parametro
     * @param tipoOperacion
     * @return devuelve un contador que previente ha contado el numero de pisos con el que coincide el tipo metido por parametro
     * @throws CatalogoException 
     */
    public int cuentaPisoPorOperacion(String tipoOperacion) throws CatalogoException {
        int contador = 0;
        
            Operacion operacion = Operacion.valueOf(tipoOperacion.toUpperCase());
            if(operacion!=Operacion.ALQUILER && operacion!=Operacion.VENTA){
                throw new CatalogoException("La operación no puede ser diferente a alquiler o venta.");
            }

            for (Piso piso : this.catalogo) {
                if (piso.getOperacion().equals(operacion)){
                    contador++;
                }
            }
        return contador;
    }
    
    //8 
    /**
     * Este metodo añade el piso que entra por parametro a una lista
     * @param piso
     * @throws CatalogoException 
     */
    public void aniadePiso(Piso piso) throws CatalogoException{
        boolean b = this.catalogo.contains(piso);
        if(!b){
            this.catalogo.add(piso);
        }
        else{
            throw new CatalogoException("El piso ya existe en este catálogo");
        }
    }
    
    //9
    /**
     * Este metodo elimina el piso que entra por parametro a una lista
     * @param piso
     * @throws CatalogoException 
     */
    public void eliminaPiso(Piso piso) throws CatalogoException{
        boolean b = this.catalogo.contains(piso);
        if(b){
            this.catalogo.remove(piso);
        }
        else{
            throw new CatalogoException("No se puede borrar un piso que no exixte");
        }
    }
    
    //10
    /**
     * Este metodo calcula el precio total de los pisos que compartan la planta introducida por parametro
     * @param planta
     * @return la suma de los precios 
     */
    public double calculaPrecioTotalDePlanta(int planta){
        double sum = 0;
        
        for(Piso p:catalogo){
            if(p.getPlanta()==planta){
                sum = sum + p.getPrecio();
            }
        }
        return sum;
    }
    
    //11
    /**
     * ordena una lista de pisos y devuelve la direccion del piso con menor precio por superficie
     * @return la direccion 
     */
    public String getDireccionPisoConMenorPrecioPorSuperficie(){
        List<Piso> lista = catalogo;
        Collections.sort(lista, new ComparadorPorPrecioPorSuperficie());
        return lista.get(0).getDireccion();     
    }
    
    //12
    /**
     * Obtiene una lista de pisos con una superficie mayor y un precio menor al del parametro
     * @param superficie
     * @param precio
     * @return la lista de pisos
     */
    public List<Piso> getPisosSuperficieMayorPrecioMenor(double superficie, double precio){
        List<Piso> lista = new ArrayList();
        
        for(Piso p:catalogo){
            if(p.getPrecio()<precio&&p.getSuperficie()>superficie){
                lista.add(p);
            }
        }
        return lista;
    }
    
    //13
    /**
     * Ordena el catalogo por superficie en orden ascendente
     */
    public void ordenaCatalogoPorSuperficieAsc(){
        Collections.sort(catalogo, new ComparadorPorSuperficie());
    }
    
    //14
    /**
     * Recorre una lista y devuelve el piso mas barato
     * @param precio
     * @return el piso mas barato
     */
    public boolean hayPisoMasBarato(double precio){
        List<Piso> lista = catalogo;
        Collections.sort(lista, new ComparadorPorPrecio());
        if(lista.get(0).getPrecio()<precio){
            return true;
        }
        else{
            return false;
        }
    }
    
    //15
    /**
     * confirma o desmiente si la planta pasada por parámetro es la mas alta
     * @param planta
     * @return un boolean 
     */
    public boolean esLaPlantaMasAlta(int planta){
        List<Piso> lista = catalogo;
        Collections.sort(lista, new ComparadorPorPlanta());
        if(lista.get(0).getPlanta()<planta){
            return true;
        }
        else{
            return false;
        }
    }
    
    //16
    /**
     * añade una rebaja dada por parametro si la superfcie del piso es mayor a la pasada por parámetro
     * @param porcentajeRebaja
     * @param superficie 
     */
    public void añadeRebajaSiPisoEsMayorQueSuperficie(int porcentajeRebaja, double superficie){
        boolean b = false;
        
        for (int i = 0; i < catalogo.size(); i++) {
            if(catalogo.get(i).getSuperficie()>superficie){
                catalogo.get(i).setPrecio(catalogo.get(i).getPrecio()-catalogo.get(i).getPrecio()/100*porcentajeRebaja);
                b = true;
            }
        }
        if(b){
            System.out.println("Se han rebajado los pisos");
        }
        else{
            System.out.println("No hay ningún piso que se pueda rebajar");
        }  
    }
   

   

    
    
    
}
