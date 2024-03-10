/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import Catalogo.Catalogo;
import Excepciones.CatalogoException;
import Excepciones.MenuException;
import Vivienda.*;
import java.util.Scanner;

/**
 *
 * @author javie
 */
public class Menu {

    
    /**
     * realiza una operacion dependiendo de la opcion dada
     * @param sc
     * @param catalogo
     * @throws CatalogoException 
     */
    public static void menu(Scanner sc, Catalogo catalogo) throws CatalogoException{
        int option;
        do{
            System.out.println("1. Añadir nuevo piso");
            System.out.println("2. Eliminar un piso");
            System.out.println("3. Mostra piso con el menor precio por superficie");
            System.out.println("4. Rebajar pisos");
            System.out.println("5. Filtrar por precio  por superficie");
            System.out.println("6. Visualizar catálogo");
            System.out.println("7. Salir del menú");
            option = sc.nextInt();
        
            switch(option){
                case 1:
                    menuOpcionUno(sc, catalogo);
                    break;
                case 2:
                    catalogoOpcionDos(sc, catalogo);
                    break;
                case 3:
                    menuOpcionTres(catalogo);
                    break;
                case 4:
                    menuOpcionCuatro(sc, catalogo);
                    break;
                case 5:
                    menuOpcionCinco(sc, catalogo);
                    break;
                case 6:
                    menuOpcionSeis(catalogo);
                    break;
                case 7:
                    System.out.println("Hasta la proxima");;
                    break;
                default:
                    System.out.println("La opción debe estar entre 1 y 7");
                    break;
            }
            } while(option != 7);
    }
    
    /**
     * Añade un piso a el catálogo dado por parámetro
     * @param sc
     * @param catalogo
     * @throws CatalogoException 
     */
    public static void menuOpcionUno(Scanner sc, Catalogo catalogo) throws CatalogoException{
        System.out.println("Escriba el numero de planta");
        int planta = Integer.parseInt(sc.nextLine());
        
        System.out.println("Escriba la letra de puerta");
        String puerta= "";
        try{
            String prueba = sc.nextLine();
            compruebaPuerta(prueba);
            puerta = prueba;
            
        }catch(MenuException e){
            System.out.println(e);
        }
        
        System.out.println("Escriba la superficie");
        double superficie = Double.parseDouble(sc.nextLine());
        
        System.out.println("Escriba el precio");
        double precio = Double.parseDouble(sc.nextLine());
        
        System.out.println("Elija el tipo de operación");
        System.out.println("1. Venta");
        System.out.println("2. Alquiler");
        System.out.println("3. Alquiler con opción a venta");
        int eleccion = Integer.parseInt(sc.nextLine());
        Operacion operacion = null;
        switch(eleccion){
            case 1:
                operacion = Operacion.VENTA;
                break;
            case 2:
                operacion = Operacion.ALQUILER;
                break;
            case 3:
                operacion = Operacion.ALQUILER_CON_OPCION_A_VENTA;
                break;
            default:
                System.out.println("La operación debe ser válida");
                break;
        }
        System.out.println("Escriba la dirección");
        String direccion = sc.nextLine();
        
        Piso p = new PisoImpl(planta, puerta.charAt(0), superficie, precio, operacion, direccion);
        
        catalogo.aniadePiso(p);
        
        if(catalogo.getCatalogo().contains(p)){
            System.out.println("La operación se ha realizado con exito");
        }
        else{
            System.out.println("La operación no pudo realizarse");
        }
        
        System.out.println(catalogo.getCatalogo());
    }
    
    /**
     * borra un piso de el catalogo dao por parametro
     * @param sc
     * @param catalogo
     * @throws CatalogoException 
     */
    public static void catalogoOpcionDos(Scanner sc, Catalogo catalogo) throws CatalogoException{
        System.out.println("Escriba el numero de planta");
        int planta = Integer.parseInt(sc.nextLine());     
        System.out.println("Escriba la letra de puerta");
        String puerta= "";
        try{
            String prueba = sc.nextLine();
            compruebaPuerta(prueba);
            puerta = prueba;           
        }catch(MenuException e){
            System.out.println(e);
        }
        System.out.println("Escriba la dirección");
        String direccion = sc.nextLine();

        Piso p = new PisoImpl(planta, puerta.charAt(0), 0, 0, null, direccion);
        
        catalogo.eliminaPiso(p);
        
        if(!catalogo.getCatalogo().contains(p)){
            System.out.println("El piso se ha borrado correctamente");
        }
        else{
            System.out.println("El piso no ha podido ser borrado");
        }
    }

    /**
     * muestra el piso con el menor precio por superficie
     * @param catalogo 
     */
    public static void menuOpcionTres(Catalogo catalogo){
        System.out.println(catalogo.getDireccionPisoConMenorPrecioPorSuperficie());
    }
    
    /**
     * rebaja los pisos que sean mayor que la superficie pasada por un metodo interno
     * @param sc
     * @param catalogo 
     */
    private static void menuOpcionCuatro(Scanner sc, Catalogo catalogo){
        System.out.println("Introduce la superficie");
        double superficie = Double.parseDouble(sc.nextLine());
        System.out.println("Introduce el porcentaje de rebaja");
        int rebaja = Integer.parseInt(sc.nextLine());
        
        catalogo.añadeRebajaSiPisoEsMayorQueSuperficie(rebaja, superficie);
        System.out.println("Los pisos con una superficie de mas de " + superficie + "m se han rebajado correctamente.");
        System.out.println(catalogo.getCatalogo());
    }
    
    /**
     * Sirve para filtrar por precio y superficie
     * @param sc
     * @param catalogo 
     */
    public static void menuOpcionCinco(Scanner sc, Catalogo catalogo){
        System.out.println("Introduzca el precio para la comparación: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.println("Introduzca la superficie para la comparación: ");
        double superficie = Double.parseDouble(sc.nextLine());
        System.out.println(catalogo.getPisosSuperficieMayorPrecioMenor(superficie, precio));
    }
    
    /**
     * Con este metodo se puede visulaizar el catalogo
     * @param catalogo 
     */
    private static void menuOpcionSeis(Catalogo catalogo){
        System.out.println(catalogo.getCatalogo());
    }
    
    public static void compruebaPuerta(String s) throws MenuException{
        if(!s.matches("[a-zA-Z]{1}")){
            throw new MenuException("La longitud de este carácter");
        }
        
    }
    


}
