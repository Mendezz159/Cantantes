/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cantantes;

import java.util.ArrayList;

/**
 *
 * @author Practica
 */
public class Cancion {
    private String Nombre;
    private ArrayList<Integer> IDsCantantes;
    private int Ventas;

    public cantanteFamoso(String Nombre, ArrayList<Integer> IDsCantantes, int Ventas) {
        this.Nombre = Nombre;
        this.IDsCantantes = IDsCantantes;
        this.Ventas =  Ventas;
    }

    public cantanteFamoso(String Nombre, int Ventas){
        this.Nombre = Nombre;
        this.IDsCantantes = new ArrayList<>();
        this.Ventas =  Ventas;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public ArrayList<Integer> getIDsCantantes() {
        return IDsCantantes;
    }

    public void setIDsCantantes(ArrayList<Integer> IDsCantantes) {
        this.IDsCantantes = IDsCantantes;
    }

    public int getVentas() {
        return Ventas;
    }

    public void setVentas(int Ventas) {
        this.Ventas = Ventas;
    }
    
    
}
