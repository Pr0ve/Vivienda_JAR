 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vivienda;

/**
 *
 * @author javie
 */
public class PisoImpl extends ViviendaImpl implements Piso{
    private int planta;
    private char puerta;

    @Override
    public int getPlanta() {
        return planta;
    }

    @Override
    public char getPuerta() {
        return puerta;
    }

    public PisoImpl(String direccion ,int planta, char puerta) {
        super(direccion);
        this.planta = planta;
        this.puerta = puerta;
    }

    public PisoImpl(int planta, char puerta, double superficie, double precio, Operacion operacion, String direccion) {
        super(superficie, precio, operacion, direccion);
        this.planta = planta;
        this.puerta = puerta;
    }
    
    public boolean equals(Object o){
        boolean r = false;
        if(o instanceof Piso){
            Piso p = (Piso) o;
            r = super.equals(o)&&this.getPlanta()==p.getPlanta()&&this.getPuerta()==p.getPuerta();
        }
        return r;
    }
    
    public int compareTo(Piso o1){
        int n;
        n = this.getDireccion().compareTo(o1.getDireccion());
        if(n==0){
            n = Integer.compare(this.getPlanta(), o1.getPlanta());
        }
        if(n==0){
            n = Character.compare(this.getPuerta(), o1.getPuerta());
        }
        return n;
    }
    
    
    
}
