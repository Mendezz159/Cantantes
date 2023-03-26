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
public class ListaCantantesFamosos {
    private ArrayList<cantanteFamoso> listacantantesFamosos = new ArrayList<>();
    
    public void AñadirCantanteFamoso(String Nombre, String DiscoConMasVentas){
        cantanteFamoso NuevoCantante = new cantanteFamoso(Nombre, DiscoConMasVentas);
        listacantantesFamosos.add(NuevoCantante);
    }

    public ListaCantantesFamosos() {
    }

    public ArrayList<cantanteFamoso> getListacantantesFamosos() {
        return listacantantesFamosos;
    }

    public void setListacantantesFamosos(ArrayList<cantanteFamoso> listacantantesFamosos) {
        this.listacantantesFamosos = listacantantesFamosos;
    }
    
    public boolean ContieneCantante(String Cantante){
        boolean Existente = false;
        
        for(cantanteFamoso ob: listacantantesFamosos){
            if(ob.getNombre().equals(Cantante)){
                Existente = true;
            }
        }
        
        return Existente;
    }
    
    public void modificarCantante(String NombreAntes, String NuevoNombre){
        for(cantanteFamoso ob: listacantantesFamosos){
            if(ob.getNombre().equals(NombreAntes)){
                ob.setNombre(NuevoNombre);
                listacantantesFamosos.set(ob.hashCode(), ob);
            }
        }
    }
    
    public void borrarCantante(String Nombre){
        for(cantanteFamoso ob: listacantantesFamosos){
            if(ob.getNombre().equals(Nombre)){
                listacantantesFamosos.remove(ob.hashCode());
            }
        }
    }
}
