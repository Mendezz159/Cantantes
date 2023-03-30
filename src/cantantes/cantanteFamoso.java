/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cantantes;

import java.util.ArrayList;

/**
 *
 * @author HP PORTATIL
 */
class cantanteFamoso {
    private String Nombre;
    private ArrayList<Integer> IDsCanciones;

    public cantanteFamoso(String Nombre, ArrayList<Integer> IDsCanciones) {
        this.Nombre = Nombre;
        this.IDsCanciones = IDsCanciones;
    }

    public cantanteFamoso(String Nombre){
        this.Nombre = Nombre;
        this.IDsCanciones = new ArrayList<>();
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public ArrayList<Integer> getDiscoConMasVentas() {
        return IDsCanciones;
    }

    public void setDiscoConMasVentas(ArrayList<Integer> IDsCanciones) {
        this.IDsCanciones = IDsCanciones;
    }
    
    public void AñadirCancion(int IDCancion){
        this.IDsCanciones.add(IDCancion);
    }
}
